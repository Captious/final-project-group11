package ua.goit.java.hotelbooking.services.impl;

import ua.goit.java.hotelbooking.dao.HotelDao;
import ua.goit.java.hotelbooking.dao.RoomDao;
import ua.goit.java.hotelbooking.dao.impl.HotelDaoImpl;
import ua.goit.java.hotelbooking.dao.impl.RoomDaoImpl;
import ua.goit.java.hotelbooking.model.Hotel;
import ua.goit.java.hotelbooking.model.Room;
import ua.goit.java.hotelbooking.services.HotelManageService;

import java.util.List;

public class HotelManageServiceImpl implements HotelManageService {

    private HotelDao hotelDao;
    private RoomDao roomDao;

    public HotelManageServiceImpl() {
        this.hotelDao = HotelDaoImpl.getInstance();
        this.roomDao = RoomDaoImpl.getInstance();
    }

    @Override
    public void add(Hotel element) {
        hotelDao.persist(element);
    }

    @Override
    public Hotel edit(Hotel element) {
        return hotelDao.persist(element);
    }

    @Override
    public boolean remove(Hotel element) {
        return hotelDao.remove(element);
    }

    @Override
    public Hotel findByName(String name) {
        return null;
    }

    @Override
    public List<Hotel> findByCity(String cityName) {
        return hotelDao.getByCity(cityName);
    }

    @Override
    public void addRoom(Hotel hotel, Room room) {
        if (!hotel.getRooms().contains(room)) {
            room.setHotel(hotel);
            roomDao.persist(room);
            hotel.getRooms().add(room);
            hotelDao.persist(hotel);
        }
    }

    @Override
    public boolean removeRoom(Hotel hotel, Room room) {
        List<Hotel> hotels = hotelDao.getAll();
        try{
            Hotel hotelUpdate = hotels.stream()
                    .filter(h -> h.getId().equals(hotel.getId()) && h.equals(hotel)).findFirst().get();
            if (hotelUpdate.getRooms().removeIf(r -> r.getId().equals(room.getId()))) {
                hotelDao.persist(hotelUpdate);
                roomDao.remove(room);
                return true;
            }
        } catch (RuntimeException exception) {
            return false;
        }
        return false;
    }
}
