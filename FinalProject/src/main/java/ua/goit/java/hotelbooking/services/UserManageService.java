package ua.goit.java.hotelbooking.services;

import ua.goit.java.hotelbooking.model.User;

public interface UserManageService extends ManageService<User> {
    boolean remove(User user);
}
