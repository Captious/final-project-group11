package ua.goit.java.hotelbooking.dao.impl;

import ua.goit.java.hotelbooking.dao.UserDao;
import ua.goit.java.hotelbooking.dao.utils.DataSerialization;
import ua.goit.java.hotelbooking.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

    private static final String FILE_PATH =
            String.format("%s/src/main/java/ua/goit/java/hotelbooking/data/user.txt",
                    System.getProperty("user.dir"));
    private static final String ENTITY = "User";

    private UserDaoImpl() {
        super(ENTITY);
    }

    private static class UserHolder {
        private final static UserDaoImpl INSTANCE = new UserDaoImpl();
    }

    public static UserDaoImpl getInstance() {
        return UserHolder.INSTANCE;
    }

    @Override
    protected String getEntityName() {
        return ENTITY;
    }

    @Override
    protected String getFilePath() {
        return FILE_PATH;
    }

    @Override
    public User persist(User element) {

        if (this.getAll().stream().anyMatch(u -> u.getLogin().toLowerCase().equals(element.getLogin().toLowerCase()))) {
            throw new RuntimeException("The user with the same login exists in the database");
        }
        return super.persist(element);
    }

    @Override
    public List<User> getAll() {
        return (ArrayList<User>) DataSerialization.deserializeData(FILE_PATH);
    }
}
