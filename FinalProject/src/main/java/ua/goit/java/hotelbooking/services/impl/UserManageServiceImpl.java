package ua.goit.java.hotelbooking.services.impl;

import ua.goit.java.hotelbooking.dao.UserDao;
import ua.goit.java.hotelbooking.dao.impl.UserDaoImpl;
import ua.goit.java.hotelbooking.model.User;
import ua.goit.java.hotelbooking.services.UserManageService;

import java.util.List;

public class UserManageServiceImpl implements UserManageService{

    private UserDao userDao;

    public UserManageServiceImpl() {
        this.userDao = UserDaoImpl.getInstance();
    }

    public UserDao getUserDao() {
        return userDao;
    }

    @Override
    public void add(User element) {
        userDao.persist(element);
    }

    @Override
    public User edit(User element) {
        return userDao.persist(element);
    }

    @Override
    public boolean remove(User user) {
        return userDao.remove(user);
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }
}
