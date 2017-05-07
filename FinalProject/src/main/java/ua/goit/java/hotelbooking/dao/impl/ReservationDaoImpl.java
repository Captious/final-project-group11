package ua.goit.java.hotelbooking.dao.impl;

import ua.goit.java.hotelbooking.dao.ReservationDao;
import ua.goit.java.hotelbooking.dao.utils.DataSerialization;
import ua.goit.java.hotelbooking.model.Reservation;

import java.util.ArrayList;
import java.util.List;

public class ReservationDaoImpl extends IdCollectionHolder implements ReservationDao {

    private static final String FILE_PATH = "FinalProject/src/main/java/ua/goit/java/hotelbooking/data/reservation.txt";
    private static final String ENTITY = "Reservation";
    private static Long lastId;

    private ReservationDaoImpl() {
        super();
        lastId = getLastIdCollection().get(ENTITY);
    }

    private static class ReservationHolder {
        private final static ReservationDaoImpl INSTANCE = new ReservationDaoImpl();
    }

    public static ReservationDaoImpl getInstance(){
        return  ReservationHolder.INSTANCE;
    }

    private Long getLastId() {
        return lastId;
    }

    private void increaseLastId() {
        lastId++;
        getLastIdCollection().put(ENTITY, lastId);
        setLastIdCollection(getLastIdCollection());
    }

    @Override
    public Reservation persist(Reservation element) {
        List<Reservation> reservation = getAll();
        if (element.getId() != null){
            throw new RuntimeException(String.format("This reservation already exists in the database %s", ENTITY));
        } else {
            increaseLastId();
            element.setId(getLastId());
            reservation.add(element);
        }
        DataSerialization.serializeData(FILE_PATH, reservation);
        return element;
    }

    @Override
    public boolean remove(Reservation element) {
        List<Reservation> reservation = getAll();
        if (element.getId() == null){
            throw new RuntimeException(String.format("There is no such element in the database %s", ENTITY));
        }
        if (reservation.removeIf(r -> r.getId().equals(element.getId()))){
            DataSerialization.serializeData(FILE_PATH, reservation);
            return true;
        }
        return false;
    }

    @Override
    public List<Reservation> getAll() {
        return (ArrayList<Reservation>) DataSerialization.deserializeData(FILE_PATH);
    }
}
