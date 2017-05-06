package ua.goit.java.hotelbooking.dao.impl;

import ua.goit.java.hotelbooking.dao.RoomDao;
import ua.goit.java.hotelbooking.dao.utils.DataSerialization;
import ua.goit.java.hotelbooking.model.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class RoomDaoImpl extends IdCollectionHolder implements RoomDao {

    private List<Room> rooms;
    private static final String FILE_PATH = "FinalProject/src/main/java/ua/goit/java/hotelbooking/data/room.txt";
    //TODO: Please follow the naming convention. Constant should be in upper case.
    private static final String entity = "Room";
    private static Long lastId;

    private RoomDaoImpl(){
        super();
        rooms = (ArrayList<Room>) DataSerialization.deserializeData(FILE_PATH);
        lastId = getLastIdCollection().get(entity);
    }

    private static class RoomHolder {
        //TODO: Please follow the naming convention. Constant should be in upper case.
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
        if (element.getId() == null){
            element.setId(getLastId());
            increaseLastId();
            getAll().add(element);
            DataSerialization.serializeData(FILE_PATH, getAll());
            return element;
        }
        try {
            int index = IntStream.range(0, getAll().size())
                    .filter(i -> element.getId().equals(getAll().get(i).getId()))
                    .findFirst()
                    .getAsInt();
            getAll().set(index, element);
            DataSerialization.serializeData(FILE_PATH, getAll());
            return element;
        } catch (RuntimeException exception) {
            System.out.printf("In the database %s there is no such id - %d.\n", entity, element.getId());
            throw new RuntimeException();
        }
    }

    @Override
    public boolean remove(Room element) {
        //TODO: Please, remove try block.
        try {
            //TODO: Please add check for null. If id is null the method should throw exception.
            long id = element.getId();
            //TODO: removeIf returns boolean. Please remove unnecessary check.
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
        return rooms;
    }

    @Override
    public Room getByHotel(String roomNumber, Long hotelId) {
        return null;
    }
}
