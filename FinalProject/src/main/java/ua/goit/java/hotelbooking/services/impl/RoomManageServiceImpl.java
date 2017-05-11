package ua.goit.java.hotelbooking.services.impl;

import ua.goit.java.hotelbooking.dao.RoomDao;
import ua.goit.java.hotelbooking.dao.impl.RoomDaoImpl;
import ua.goit.java.hotelbooking.model.Hotel;
import ua.goit.java.hotelbooking.model.Room;
import ua.goit.java.hotelbooking.services.RoomManageService;

import java.util.List;

public class RoomManageServiceImpl implements RoomManageService {

    private RoomDao roomDao;

    public RoomManageServiceImpl() {
        this.roomDao = RoomDaoImpl.getInstance();
    }

    public RoomDao getRoomDao() {
        return roomDao;
    }

    @Override
    public void add(Room element) {
        roomDao.persist(element);
    }

    @Override
    public Room edit(Room element) {
        if (roomDao.getAll().contains(element)) {
            throw new RuntimeException("Such room exists in the database.");
        }
        return roomDao.persist(element);
    }

    @Override
    public Room findByHotel(Room room, Hotel hotel) {
        return roomDao.getByHotel(room.getNumber(), hotel.getId());
    }

    @Override
    public boolean remove(Room element) {
        return roomDao.remove(element);
    }

    @Override
    public List<Room> getAll() {
        return roomDao.getAll();
    }
}



