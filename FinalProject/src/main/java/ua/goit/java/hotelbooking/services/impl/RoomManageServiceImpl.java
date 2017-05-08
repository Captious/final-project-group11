package ua.goit.java.hotelbooking.services.impl;

import ua.goit.java.hotelbooking.dao.RoomDao;
import ua.goit.java.hotelbooking.dao.impl.RoomDaoImpl;
import ua.goit.java.hotelbooking.model.Hotel;
import ua.goit.java.hotelbooking.model.Room;
import ua.goit.java.hotelbooking.services.RoomManageService;

public class RoomManageServiceImpl implements RoomManageService {

    private RoomDao roomDao;

    public RoomManageServiceImpl() {
        this.roomDao = RoomDaoImpl.getInstance();
    }

    @Override
    public void add(Room element) {
        roomDao.persist(element);
    }

    @Override
    public Room edit(Room element) {
        try {
            return roomDao.persist(element);
        } catch (RuntimeException exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }

    @Override
    public Room findByHotel(Room room, Hotel hotel) {
        return roomDao.getByHotel(room.getNumber(),hotel.getId());
    }


    public boolean remove(Room element) {
        return roomDao.remove(element);
    }
}



