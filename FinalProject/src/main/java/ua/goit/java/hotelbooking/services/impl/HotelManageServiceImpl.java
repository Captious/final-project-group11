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

    private HotelDao hotelDao = HotelDaoImpl.getInstance();
    private RoomDao roomDao = RoomDaoImpl.getInstance();

    @Override
    public void add(Hotel element) {
        hotelDao.persist(element);
    }

    @Override
    public Hotel edit(Hotel element) {
        return null;
    }

    @Override
    public boolean remove(Hotel element) {
        return false;
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
            room.setHotel(hotel);
            hotel.getRooms().add(roomDao.persist(room));
            hotelDao.persist(hotel);
        } catch (RuntimeException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public boolean removeRoom(Hotel hotel, Room room) {
        return false;
    }
}
