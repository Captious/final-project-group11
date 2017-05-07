package ua.goit.java.hotelbooking.dao.impl;

import ua.goit.java.hotelbooking.dao.ReservationDao;
import ua.goit.java.hotelbooking.dao.utils.DataSerialization;
import ua.goit.java.hotelbooking.model.Reservation;

import java.util.ArrayList;
import java.util.List;

public class ReservationDaoImpl extends IdCollectionHolder implements ReservationDao {

    //TODO: Please, remove this field. Use `getAll` method for getting reservation from file.
    private List<Reservation> reservations;
    private static final String FILE_PATH = "FinalProject/src/main/java/ua/goit/java/hotelbooking/data/reservation.txt";
    private static final String ENTITY = "Reservation";
    private static Long lastId;

    private ReservationDaoImpl() {
        super();
        reservations = (ArrayList<Reservation>) DataSerialization.deserializeData(FILE_PATH);
        lastId = getLastIdCollection().get(ENTITY);
    }

    private static class ReservationHolder {
        private final static ReservationDaoImpl INSTANCE = new ReservationDaoImpl();
    }

    public static ReservationDaoImpl getInstance(){
        return  ReservationHolder.INSTANCE;
    }

    //TODO: Why public static? It can be a private method.
    public static Long getLastId() {
        return lastId;
    }

    //TODO: Why public static? It can be a private method.
    public static void increaseLastId() {
        lastId++;
        getLastIdCollection().put(ENTITY, lastId);
        setLastIdCollection(getLastIdCollection());
    }

    @Override
    public Reservation persist(Reservation element) {
        //TODO: Please, create local variable with list of all items. `list.get(index)` is more faster instead of reading data from file and getting by index.
        if (element.getId() != null){
            throw new RuntimeException(String.format("This reservation already exists in the database %s", ENTITY));
        } else {
            increaseLastId();
            element.setId(getLastId());
            getAll().add(element);
        }
        DataSerialization.serializeData(FILE_PATH, ENTITY);
        return element;
    }

    @Override
    public boolean remove(Reservation element) {
        //TODO: Please, create local variable with list of all items. `list.get(index)` is more faster instead of reading data from file and getting by index.
        if (element.getId() == null){
            throw new RuntimeException(String.format("There is no such element in the database %s", ENTITY));
        }
        if (getAll().removeIf(reservation -> reservation.getId().equals(element.getId()))){
            DataSerialization.serializeData(FILE_PATH, getAll());
            return true;
        }
        return false;
    }

    @Override
    public List<Reservation> getAll() {
        return reservations;
    }
}
