package ua.goit.java.hotelbooking.dao.impl;

import ua.goit.java.hotelbooking.dao.ReservationDao;
import ua.goit.java.hotelbooking.dao.utils.DataSerialization;
import ua.goit.java.hotelbooking.model.Reservation;

import java.util.ArrayList;
import java.util.List;

public class ReservationDaoImpl extends IdCollectionHolder implements ReservationDao {

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

    public static Long getLastId() {
        return lastId;
    }

    public static void increaseLastId() {
        lastId++;
        getLastIdCollection().put(ENTITY, lastId);
        setLastIdCollection(getLastIdCollection());
    }

    @Override
    public Reservation persist(Reservation element) {
        if (getAll().contains(element)) {
            throw new RuntimeException(String.format("This reservation already exists in the database %s", ENTITY));
        } else {
            increaseLastId();
            element.setId(getLastId());
            getAll().add(element);
        }
        return element;
    }

    @Override
    public boolean remove(Reservation element) {
        return false;
    }

    @Override
    public List<Reservation> getAll() {
        return reservations;
    }
}
