package ua.goit.java.hotelbooking.ui.common;

import java.util.Arrays;
import java.util.List;

public class RoomAction implements Action {
    private static final List<Action> ROOM_ACTIONS = Arrays.asList(new FindRoomByHotelAction(), new MainAction());

    @Override
    public void execute(CommandLine commandLine) {
        Action action = commandLine.choose(ROOM_ACTIONS);
        action.execute(commandLine);
    }

    @Override
    public String toString() {
        return "Select room action.";
    }
}
