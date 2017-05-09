package ua.goit.java.hotelbooking.ui;

import ua.goit.java.hotelbooking.ui.common.*;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CommandLine commandLine = new CommandLine();
        List<Action> mainActions = Arrays.asList(new HotelAction(), new RoomAction(), new UserAction(), new ReservationAction());
        while (true) {
            Action action = commandLine.choose(mainActions);
            action.execute(commandLine);
        }
    }
}
