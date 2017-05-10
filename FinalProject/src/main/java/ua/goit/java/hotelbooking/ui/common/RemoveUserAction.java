package ua.goit.java.hotelbooking.ui.common;

import ua.goit.java.hotelbooking.model.User;

public class RemoveUserAction extends AbstractUserAction {
    @Override
    public void execute(CommandLine commandLine) {
        System.out.println("Select user:");
        User user = commandLine.choose(userManageService.getAll());
        userManageService.remove(user);
    }

    @Override
    public String toString() {
        return "Remove user.";
    }
}
