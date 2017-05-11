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

    public HotelDao getHotelDao() {
        return hotelDao;
    }

    public RoomDao getRoomDao() {
        return roomDao;
    }

    @Override
    public void add(Hotel element) {
        hotelDao.persist(element);
    }

    @Override
    public Hotel edit(Hotel element) {
        if (hotelDao.getAll().contains(element)) {
            throw new RuntimeException("Such hotel exists in the database.");
        }
        return hotelDao.persist(element);
    }

    @Override
    public boolean remove(Hotel element) {
        return hotelDao.remove(element);
    }

    @Override
    public Hotel findByName(String name) {
        return hotelDao.getByName(name);
    }

    @Override
    public List<Hotel> findByCity(String cityName) {
        return hotelDao.getByCity(cityName);
    }

    @Override
    public void addRoom(Hotel hotel, Room room) {
            room.setHotel(hotel);
            roomDao.persist(room);
            hotel.getRooms().add(room);
            hotelDao.persist(hotel);
    }

    @Override
    public boolean removeRoom(Hotel hotel, Room room) {
        List<Hotel> hotels = hotelDao.getAll();
        Hotel hotelUpdate = hotels.stream()
                    .filter(h -> h.getId().equals(hotel.getId())).findFirst().get();
        if (hotelUpdate.getRooms().removeIf(r -> r.getId().equals(room.getId()))) {
            hotelDao.persist(hotelUpdate);
            roomDao.remove(room);
            return true;
        }
        return false;
    }

    @Override
    public List<Hotel> getAll() {
        return hotelDao.getAll();
    }
}
