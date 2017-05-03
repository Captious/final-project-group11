package ua.goit.java.hotelbooking.dao.impl;

import ua.goit.java.hotelbooking.dao.UserDao;
import ua.goit.java.hotelbooking.dao.utils.DataSerialization;
import ua.goit.java.hotelbooking.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private List<User> rooms;
    private static final String FILE_PATH = "FinalProject/src/main/java/ua/goit/java/hotelbooking/data/user.txt";

    private UserDaoImpl(){
        rooms = (ArrayList<User>) DataSerialization.deserializeData(FILE_PATH);
        if (rooms == null) rooms = new ArrayList<>();
    }

    private static class UserHolder {
        private final static UserDaoImpl instance = new UserDaoImpl();
    }

    public static UserDaoImpl getInstance(){
        return  UserHolder.instance;
    }
    @Override
    public User persist(User element) {
        return null;
    }

    @Override
    public boolean remove(User element) {
        return false;
    }

    @Override
    public List<User> getAll() {
        return null;
    }
}
