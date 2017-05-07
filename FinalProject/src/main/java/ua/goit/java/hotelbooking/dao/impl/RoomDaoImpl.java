package ua.goit.java.hotelbooking.dao.impl;

import ua.goit.java.hotelbooking.dao.RoomDao;
import ua.goit.java.hotelbooking.dao.utils.DataSerialization;
import ua.goit.java.hotelbooking.model.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class RoomDaoImpl extends IdCollectionHolder implements RoomDao {

    private static final String FILE_PATH = "FinalProject/src/main/java/ua/goit/java/hotelbooking/data/room.txt";
    private static final String ENTITY = "Room";
    private static Long lastId;

    private RoomDaoImpl() {
        super();
        lastId = getLastIdCollection().get(ENTITY);
    }

    private static class RoomHolder {
        private final static RoomDaoImpl INSTANCE = new RoomDaoImpl();
    }

    public static RoomDaoImpl getInstance() {
        return  RoomHolder.INSTANCE;
    }

    private Long getLastId() {
        return lastId;
    }

    private void increaseLastId(){
        lastId++;
        getLastIdCollection().put(ENTITY, lastId);
        setLastIdCollection(getLastIdCollection());
    }

    @Override
    public Room persist(Room element) {
        List<Room> rooms = getAll();
        if (element.getId() == null){
            increaseLastId();
            element.setId(getLastId());
            rooms.add(element);
        } else {
            try {
                int index = IntStream.range(0, rooms.size())
                        .filter(i -> element.getId().equals(rooms.get(i).getId()))
                        .findFirst()
                        .getAsInt();
                rooms.set(index, element);
            } catch (RuntimeException exception) {
                throw new RuntimeException(String.format("There is no element with that ID (%d) in the databaseIn %s",
                        element.getId(), ENTITY));
            }
        }
        DataSerialization.serializeData(FILE_PATH, rooms);
        return element;
    }

    @Override
    public boolean remove(Room element) {
        long id = element.getId();
        if(Long.valueOf(id) == null){
            throw new RuntimeException("There is no such hotel in database");
        }
        if((getAll().removeIf(x -> x.getId() == id) == true)) {
            DataSerialization.serializeData(FILE_PATH, getAll());
            return true;
        }
        return false;
    }

    @Override
    public List<Room> getAll() {
        return (ArrayList<Room>) DataSerialization.deserializeData(FILE_PATH);
    }

    @Override
    public Room getByHotel(String roomNumber, Long hotelId) {
        return null;
    }
}
