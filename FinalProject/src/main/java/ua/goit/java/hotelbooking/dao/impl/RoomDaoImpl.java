package ua.goit.java.hotelbooking.dao.impl;

import ua.goit.java.hotelbooking.dao.RoomDao;
import ua.goit.java.hotelbooking.dao.utils.DataSerialization;
import ua.goit.java.hotelbooking.model.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class RoomDaoImpl extends IdCollectionHolder implements RoomDao {

    //TODO: Please, remove this field. Use `getAll` method for getting rooms from file.
    private List<Room> rooms;
    private static final String FILE_PATH = "FinalProject/src/main/java/ua/goit/java/hotelbooking/data/room.txt";
    private static final String ENTITY = "Room";
    private static Long lastId;

    private RoomDaoImpl(){
        super();
        rooms = (ArrayList<Room>) DataSerialization.deserializeData(FILE_PATH);
        lastId = getLastIdCollection().get(ENTITY);
    }

    private static class RoomHolder {
        private final static RoomDaoImpl INSTANCE = new RoomDaoImpl();
    }

    public static RoomDaoImpl getInstance(){
        return  RoomHolder.INSTANCE;
    }

    //TODO: Why public static? It can be a private method.
    public static Long getLastId() {
        return lastId;
    }

    //TODO: Why public static? It can be a private method.
    public static void increaseLastId(){
        lastId++;
        getLastIdCollection().put(ENTITY, lastId);
        setLastIdCollection(getLastIdCollection());
    }

    @Override
    public Room persist(Room element) {
        //TODO: Please, create local variable with list of all items. `list.get(index)` is more faster instead of reading data from file and getting by index.
        if (element.getId() == null){
            increaseLastId();
            element.setId(getLastId());
            getAll().add(element);
        } else {
            try {
                int index = IntStream.range(0, getAll().size())
                        .filter(i -> element.getId().equals(getAll().get(i).getId()))
                        .findFirst()
                        .getAsInt();
                getAll().set(index, element);
            } catch (RuntimeException exception) {
                throw new RuntimeException(String.format("There is no element with that ID (%d) in the databaseIn %s",
                        element.getId(), ENTITY));
            }
        }
        DataSerialization.serializeData(FILE_PATH, getAll());
        return element;
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
