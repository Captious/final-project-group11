package ua.goit.java.hotelbooking.services.impl;

import ua.goit.java.hotelbooking.model.Reservation;
import ua.goit.java.hotelbooking.model.Room;
import ua.goit.java.hotelbooking.model.User;
import ua.goit.java.hotelbooking.services.ReservationService;

import java.util.Date;

public class ReservationServiceImpl implements ReservationService {

    @Override
    public void add(Room room, Date date, User user) {

    }

    @Override
    public boolean remove(Reservation reservation) {
        return false;
    }
}
