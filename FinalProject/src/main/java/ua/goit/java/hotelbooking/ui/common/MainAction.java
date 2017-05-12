package ua.goit.java.hotelbooking.ui.common;

import java.util.Arrays;
import java.util.List;

public class MainAction implements Action{

    private static final List<Action> MAIN_ACTIONS = Arrays.asList(
            new HotelAction(),
            new RoomAction(),
            new UserAction(),
            new ReservationAction(),
            new ExitAction());

    @Override
    public void execute(CommandLine commandLine) {
        Action action = commandLine.choose(MAIN_ACTIONS);
        action.execute(commandLine);
    }

    @Override
    public String toString() {
        return "Main menu";
    }


}
