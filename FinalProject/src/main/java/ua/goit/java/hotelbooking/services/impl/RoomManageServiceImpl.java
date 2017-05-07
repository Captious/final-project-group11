package ua.goit.java.hotelbooking.services.impl;

import ua.goit.java.hotelbooking.dao.RoomDao;
import ua.goit.java.hotelbooking.dao.impl.RoomDaoImpl;
import ua.goit.java.hotelbooking.model.Hotel;
import ua.goit.java.hotelbooking.model.Room;
import ua.goit.java.hotelbooking.services.RoomManageService;

public class RoomManageServiceImpl implements RoomManageService {

    private RoomDao roomDao = RoomDaoImpl.getInstance();

    @Override
    public void add(Room element) {

    }

    @Override
    public Room edit(Room element) {
        //TODO: Return the object that returned from `roomDao.persist()`.
        try {
            roomDao.persist(element);
        } catch (RuntimeException exception) {
            //TODO: Please, rethrow this exception. Handling of exceptions will be implement in other US.
            System.out.println(exception.getMessage());
        }
        //TODO: Please, remove this return.
        return element;
    }

    @Override
    public Room findByHotel(Room room, Hotel hotel) {
        return null;
    }
}
