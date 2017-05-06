package ua.goit.java.hotelbooking.dao.impl;

import ua.goit.java.hotelbooking.dao.ReservationDao;
import ua.goit.java.hotelbooking.dao.utils.DataSerialization;
import ua.goit.java.hotelbooking.model.Reservation;

import java.util.ArrayList;
import java.util.List;

public class ReservationDaoImpl extends IdCollectionHolder implements ReservationDao{

    private List<Reservation> rooms;
    private static final String FILE_PATH = "FinalProject/src/main/java/ua/goit/java/hotelbooking/data/reservation.txt";
    private static final String ENTITY = "Reservation";
    private static Long lastId;

    private ReservationDaoImpl(){
        super();
        rooms = (ArrayList<Reservation>) DataSerialization.deserializeData(FILE_PATH);
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

    public static void increaseLastId(){
        lastId++;
        getLastIdCollection().put(ENTITY, lastId);
        setLastIdCollection(getLastIdCollection());
    }

    @Override
    public Reservation persist(Reservation element) {
        return null;
    }

    @Override
    public boolean remove(Reservation element) {
        return false;
    }

    @Override
    public List<Reservation> getAll() {
        return null;
    }
}
