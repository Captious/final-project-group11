package ua.goit.java.hotelbooking.dao.impl;

import ua.goit.java.hotelbooking.dao.RoomDao;
import ua.goit.java.hotelbooking.dao.utils.DataSerialization;
import ua.goit.java.hotelbooking.model.Room;

import java.util.ArrayList;
import java.util.List;

public class RoomDaoImpl implements RoomDao {

    private List<Room> rooms;
    private static final String FILE_PATH = "FinalProject/src/main/java/ua/goit/java/hotelbooking/data/room.txt";

    private RoomDaoImpl(){
        rooms = (ArrayList<Room>) DataSerialization.deserializeData(FILE_PATH);
        if (rooms == null) rooms = new ArrayList<Room>();
    }

    private static class RoomHolder {
        private final static RoomDaoImpl instance = new RoomDaoImpl();
    }

    public static RoomDaoImpl getInstance(){
        return  RoomHolder.instance;
    }
    
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
