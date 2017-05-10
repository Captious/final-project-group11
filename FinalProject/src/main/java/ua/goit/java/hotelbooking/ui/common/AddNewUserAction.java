package ua.goit.java.hotelbooking.ui.common;

import ua.goit.java.hotelbooking.model.User;

public class AddNewUserAction extends AbstractUserAction {
    @Override
    public void execute(CommandLine commandLine) {
        System.out.println("Input user name and surname.");
        String userNameAndSurname = getValidString();
        User user = new User(userNameAndSurname);
        userManageService.add(user);
    }

    @Override
    public String toString() {
        return "Insert new user.";
    }
}
