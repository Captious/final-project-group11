package ua.goit.java.hotelbooking.services;

import ua.goit.java.hotelbooking.model.Reservation;
import ua.goit.java.hotelbooking.model.Room;
import ua.goit.java.hotelbooking.model.User;

import java.util.Date;

public interface ReservationService {
    void add(Room room, Date date, User user);
    boolean remove(Reservation reservation);
}
