package ua.goit.java.hotelbooking.dao.impl;

import ua.goit.java.hotelbooking.dao.ReservationDao;
import ua.goit.java.hotelbooking.dao.utils.DataSerialization;
import ua.goit.java.hotelbooking.model.Reservation;

import java.util.ArrayList;
import java.util.List;

public class ReservationDaoImpl implements ReservationDao{

    private List<Reservation> rooms;
    private static final String FILE_PATH = "FinalProject/src/main/java/ua/goit/java/hotelbooking/data/reservation.txt";

    private ReservationDaoImpl(){
        rooms = (ArrayList<Reservation>) DataSerialization.deserializeData(FILE_PATH);
        if (rooms == null) rooms = new ArrayList<>();
    }

    private static class ReservationHolder {
        private final static ReservationDaoImpl instance = new ReservationDaoImpl();
    }

    public static ReservationDaoImpl getInstance(){
        return  ReservationHolder.instance;
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
