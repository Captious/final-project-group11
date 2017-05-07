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
        return null;
    }

    @Override
    public void addRoom(Hotel hotel, Room room) {
        try {
            //TODO: There need to persist room too.
            roomDao.persist(room);
            room.setHotel(hotel);
            hotel.getRooms().add(roomDao.persist(room));
            hotelDao.persist(hotel);
        } catch (RuntimeException exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }

    @Override
    public boolean removeRoom(Hotel hotel, Room room) {
        return false;
    }
}
