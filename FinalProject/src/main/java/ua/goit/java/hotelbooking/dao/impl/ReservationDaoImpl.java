package ua.goit.java.hotelbooking.dao.impl;

import ua.goit.java.hotelbooking.dao.ReservationDao;
import ua.goit.java.hotelbooking.dao.utils.DataSerialization;
import ua.goit.java.hotelbooking.model.Reservation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReservationDaoImpl extends IdCollectionHolder implements ReservationDao{

    private List<Reservation> rooms;
    private static final String FILE_PATH = "FinalProject/src/main/java/ua/goit/java/hotelbooking/data/reservation.txt";
    //TODO: Please follow the naming convention. Constant should be in upper case.
    private static final String entity = "Reservation";
    private static Long lastId;

    private ReservationDaoImpl(){
        super();
        rooms = (ArrayList<Reservation>) DataSerialization.deserializeData(FILE_PATH);
        lastId = getLastIdCollection().get(entity);
    }

    private static class ReservationHolder {
        //TODO: Please follow the naming convention. Constant should be in upper case.
        private final static ReservationDaoImpl instance = new ReservationDaoImpl();
    }

    public static ReservationDaoImpl getInstance(){
        return  ReservationHolder.instance;
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
