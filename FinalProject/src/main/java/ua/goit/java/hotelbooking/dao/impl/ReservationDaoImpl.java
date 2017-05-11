package ua.goit.java.hotelbooking.dao.impl;

import ua.goit.java.hotelbooking.dao.ReservationDao;
import ua.goit.java.hotelbooking.dao.utils.DataSerialization;
import ua.goit.java.hotelbooking.model.Reservation;

import java.util.ArrayList;
import java.util.List;

public class ReservationDaoImpl extends BaseDaoImpl<Reservation> implements ReservationDao {

    private static final String FILE_PATH =
            String.format("%s/src/main/java/ua/goit/java/hotelbooking/data/reservation.txt",
                    System.getProperty("user.dir"));
    private static final String ENTITY = "Reservation";

    private ReservationDaoImpl() {
        super(ENTITY);
    }

    private static class ReservationHolder {
        private final static ReservationDaoImpl INSTANCE = new ReservationDaoImpl();
    }

    public static ReservationDaoImpl getInstance() {
        return ReservationHolder.INSTANCE;
    }

    @Override
    protected String getEntityName() {
        return ENTITY;
    }

    @Override
    protected String getFilePath() {
        return FILE_PATH;
    }

    @Override
    public Reservation persist(Reservation element) {
        List<Reservation> reservation = getAll();
        if (element.getId() != null || reservation.contains(element)) {
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
    public List<Reservation> getAll() {
        return (ArrayList<Reservation>) DataSerialization.deserializeData(FILE_PATH);
    }
}
