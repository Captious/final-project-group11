package ua.goit.java.hotelbooking.services.impl;

import ua.goit.java.hotelbooking.dao.ReservationDao;
import ua.goit.java.hotelbooking.dao.impl.ReservationDaoImpl;
import ua.goit.java.hotelbooking.model.Reservation;
import ua.goit.java.hotelbooking.model.Room;
import ua.goit.java.hotelbooking.model.User;
import ua.goit.java.hotelbooking.services.ReservationService;

import java.util.Date;
import java.util.List;

public class ReservationServiceImpl implements ReservationService {

    private ReservationDao reservationDao;

    public ReservationServiceImpl() {
        this.reservationDao = ReservationDaoImpl.getInstance();
    }

    public ReservationDao getReservationDao() {
        return reservationDao;
    }

    @Override
    public void add(Room room, Date date, User user) {
        reservationDao.persist(new Reservation(room, date, user));
    }

    @Override
    public boolean remove(Reservation reservation) {
        return reservationDao.remove(reservation);
    }

    @Override
    public List<Reservation> getAll() {
        return reservationDao.getAll();
    }
}
