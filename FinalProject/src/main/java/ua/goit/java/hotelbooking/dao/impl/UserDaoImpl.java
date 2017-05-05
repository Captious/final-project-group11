package ua.goit.java.hotelbooking.dao.impl;

import ua.goit.java.hotelbooking.dao.UserDao;
import ua.goit.java.hotelbooking.dao.utils.DataSerialization;
import ua.goit.java.hotelbooking.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoImpl extends IdCollectionHolder implements UserDao {

    private List<User> users;
    private static final String FILE_PATH = "FinalProject/src/main/java/ua/goit/java/hotelbooking/data/user.txt";
    private static final String entity = "User";
    private static Long lastId;

    private UserDaoImpl(){
        super();
        users = (ArrayList<User>) DataSerialization.deserializeData(FILE_PATH);
        lastId = getLastIdCollection().get(entity);
    }

    private static class UserHolder {
        private final static UserDaoImpl instance = new UserDaoImpl();
    }

    public static Long getLastId() {
        return lastId;
    }

    public static void increaseLastId(){
        lastId++;
        getLastIdCollection().put(entity, lastId);
        setLastIdCollection(getLastIdCollection());
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
        try {
            long id = element.getId();
            if((users.removeIf(x -> x.getId() == id) == true)){
                DataSerialization.serializeData(FILE_PATH, users);
                return true;
            }
        } catch (RuntimeException exception) {
            System.out.println("There is no such user in database");
        }
        return false;
    }

    @Override
    public List<User> getAll() {
        return null;
    }
}
