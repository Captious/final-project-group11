package ua.goit.java.hotelbooking.ui.common;

import java.util.Arrays;
import java.util.List;

public class ReservationAction implements Action {
    private static final List<Action> RESERVATION_ACTIONS = Arrays.asList(new AddReservationAction(), new RemoveReservationAction(), new MainAction());

    @Override
    public void execute(CommandLine commandLine) {
        Action action = commandLine.choose(RESERVATION_ACTIONS);
        action.execute(commandLine);
    }

    @Override
    public String toString() {
        return "Select reservation action.";
    }
}
