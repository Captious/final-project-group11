package ua.goit.java.hotelbooking.dao.impl;

import ua.goit.java.hotelbooking.dao.RoomDao;
import ua.goit.java.hotelbooking.dao.utils.DataSerialization;
import ua.goit.java.hotelbooking.model.Room;

import java.util.ArrayList;
import java.util.List;

public class RoomDaoImpl extends IdCollectionHolder implements RoomDao {

    private List<Room> rooms;
    private static final String FILE_PATH = "FinalProject/src/main/java/ua/goit/java/hotelbooking/data/room.txt";
    private static final String entity = "Room";
    private static Long lastId;

    private RoomDaoImpl(){
        super();
        rooms = (ArrayList<Room>) DataSerialization.deserializeData(FILE_PATH);
        lastId = getLastIdCollection().get(entity);
    }

    private static class RoomHolder {
        private final static RoomDaoImpl instance = new RoomDaoImpl();
    }

    public static RoomDaoImpl getInstance(){
        return  RoomHolder.instance;
    }

    public static Long getLastId() {
        return lastId;
    }

    public static void increaseLastId(){
        lastId++;
        getLastIdCollection().put(entity, lastId);
        setLastIdCollection(getLastIdCollection());
    }

    @Override
    public Room persist(Room element) {
        return null;
    }

    @Override
    public boolean remove(Room element) {
        try {
            long id = element.getId();
            if((rooms.removeIf(x -> x.getId() == id) == true)){
                DataSerialization.serializeData(FILE_PATH, rooms);
                return true;
            }
        } catch (RuntimeException exception) {
            System.out.println("There is no such room in database");
        }
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
