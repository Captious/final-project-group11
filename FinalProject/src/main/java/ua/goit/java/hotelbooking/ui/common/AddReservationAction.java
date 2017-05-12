package ua.goit.java.hotelbooking.ui.common;

import ua.goit.java.hotelbooking.model.Room;
import ua.goit.java.hotelbooking.model.User;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddReservationAction extends AbstractReservationAction {

    @Override
    public void execute() {
        System.out.println("Select user:");
        User user = commandLine.choose(userManageService.getAll());
        System.out.println("Select room:");
        Room room = commandLine.choose(roomManageService.getAll());
        Date reservationDate = getValidReservationDate();
        reservationService.add(room, reservationDate, user);
    }

    private Date getValidReservationDate() {
        System.out.println("Input reservation date in format DD.MM.YYYY");
        try {
            DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            return dateFormat.parse(scanner.nextLine());
        } catch (ParseException e) {
            System.out.println("Not correct format. Please, try again.");
            return getValidReservationDate();
        }
    }

    @Override
    public String toString() {
        return "Insert new reservation.";
    }
}
