package ua.goit.java.hotelbooking.ui.common;

import ua.goit.java.hotelbooking.model.Reservation;

public class RemoveReservationAction extends AbstractReservationAction {

    @Override
    public void execute() {
        System.out.println("Select reservation:");
        Reservation reservation = commandLine.choose(reservationService.getAll());
        reservationService.remove(reservation);
    }

    @Override
    public String toString() {
        return "Remove reservation.";
    }
}
