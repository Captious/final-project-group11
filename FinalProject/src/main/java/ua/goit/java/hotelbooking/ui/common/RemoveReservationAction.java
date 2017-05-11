package ua.goit.java.hotelbooking.ui.common;

import ua.goit.java.hotelbooking.model.Reservation;

public class RemoveReservationAction extends AbstractReservationAction {
    @Override
    public void execute(CommandLine commandLine) {
        System.out.println("Select reservation:");
        Reservation reservation = commandLine.choose(reservationService.getAll());
        try {
            reservationService.remove(reservation);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Remove reservation.";
    }
}
