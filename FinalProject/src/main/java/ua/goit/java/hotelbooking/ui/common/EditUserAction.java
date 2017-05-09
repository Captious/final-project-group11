package ua.goit.java.hotelbooking.ui.common;

import ua.goit.java.hotelbooking.model.User;

public class EditUserAction extends AbstractUserAction {
    @Override
    public void execute(CommandLine commandLine) {
        System.out.println("Select user:");
        User user = commandLine.choose(userManageService.getAll());
        System.out.println("Input user name and surname:");
        String userNameAndSurname = scanner.nextLine();
        user.setFio(userNameAndSurname);
        userManageService.edit(user);
    }

    @Override
    public String toString() {
        return "Edit user.";
    }
}
