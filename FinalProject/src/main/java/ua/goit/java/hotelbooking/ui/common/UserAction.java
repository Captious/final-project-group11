package ua.goit.java.hotelbooking.ui.common;

import java.util.Arrays;
import java.util.List;

public class UserAction implements Action {
    private static final List<Action> USER_ACTIONS = Arrays.asList(new AddNewUserAction(), new EditUserAction(), new RemoveUserAction(), new MainAction());

    @Override
    public void execute(CommandLine commandLine) {
        Action action = commandLine.choose(USER_ACTIONS);
        action.execute(commandLine);
    }

    @Override
    public String toString() {
        return "Select user action.";
    }
}
