package ua.goit.java.hotelbooking.ui.common;

import java.util.Arrays;
import java.util.List;

public class HotelAction implements Action {
    private static final List<Action> HOTEL_ACTIONS = Arrays.asList(
            new AddNewHotelAction(),
            new EditHotelAction(),
            new RemoveHotelAction(),
            new AddNewRoomAction(),
            new EditRoomAction(),
            new RemoveRoomAction(),
            new FindHotelByCityAction(),
            new FindHotelByNameAction(),
            new MainAction());

    @Override
    public void execute(CommandLine commandLine) {
        Action action = commandLine.choose(HOTEL_ACTIONS);
        action.execute(commandLine);
    }

    @Override
    public String toString() {
        return "Select hotel action.";
    }
}
