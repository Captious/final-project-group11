package ua.goit.java.hotelbooking.dao.impl;

import ua.goit.java.hotelbooking.dao.RoomDao;
import ua.goit.java.hotelbooking.model.Room;

import java.util.List;

public class RoomDaoImpl implements RoomDao {
    @Override
    public Room persist(Room element) {
        return null;
    }

    @Override
    public boolean remove(Room element) {
        return false;
    }

    @Override
    public List<Room> getAll() {
        return null;
    }

    @Override
    public Room getByHotel(String roomNumber, Long hotelId) {
        return null;
    }
}
