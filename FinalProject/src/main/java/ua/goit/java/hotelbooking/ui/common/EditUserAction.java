package ua.goit.java.hotelbooking.ui.common;

import ua.goit.java.hotelbooking.model.User;

public class EditUserAction extends AbstractUserAction {

    @Override
    public void execute() {
        System.out.println("Select user:");
        User user = commandLine.choose(userManageService.getAll());
        System.out.println("Input user name and surname:");
        String userNameAndSurname = getValidString();
        user.setFio(userNameAndSurname);
        userManageService.edit(user);
        System.out.println("Input user login.");
        String userLogin = getValidString();
        user.setLogin(userLogin);
        userManageService.add(user);
    }

    @Override
    public String toString() {
        return "Edit user.";
    }
}
