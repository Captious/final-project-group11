package ua.goit.java.hotelbooking.services.impl;

import ua.goit.java.hotelbooking.dao.ReservationDao;
import ua.goit.java.hotelbooking.dao.impl.ReservationDaoImpl;
import ua.goit.java.hotelbooking.model.Reservation;
import ua.goit.java.hotelbooking.model.Room;
import ua.goit.java.hotelbooking.model.User;
import ua.goit.java.hotelbooking.services.ReservationService;

import java.util.Date;

public class ReservationServiceImpl implements ReservationService {

    //TODO: Please, initialize fields in default constructor.
    private ReservationDao reservationDao = ReservationDaoImpl.getInstance();

    @Override
    public void add(Room room, Date date, User user) {
        Reservation reservation = new Reservation(room, date, user);
        try {
            reservationDao.persist(reservation);
        } catch (RuntimeException exception) {
            //TODO: Please, rethrow this exception. Handling of exceptions will be implement in other US.
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public boolean remove(Reservation reservation) {
        try {
            return reservationDao.remove(reservation);
        } catch (RuntimeException exception) {
            System.out.println(exception.getMessage());
        }
        //TODO: Remove it return. In catch block just rethrow an exception.
        return false;
    }
}
