package ua.goit.java.hotelbooking.dao.impl;

import ua.goit.java.hotelbooking.dao.UserDao;
import ua.goit.java.hotelbooking.dao.utils.DataSerialization;
import ua.goit.java.hotelbooking.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends IdCollectionHolder implements UserDao {

    //TODO: Please, remove this field. Use `getAll` method for getting users from file.
    private List<User> users;
    private static final String FILE_PATH = "FinalProject/src/main/java/ua/goit/java/hotelbooking/data/user.txt";
    private static final String ENTITY = "User";
    private static Long lastId;

    private UserDaoImpl(){
        super();
        users = (ArrayList<User>) DataSerialization.deserializeData(FILE_PATH);
        lastId = getLastIdCollection().get(ENTITY);
    }

    private static class UserHolder {
        private final static UserDaoImpl INSTANCE = new UserDaoImpl();
    }

    //TODO: Why public static? It can be a private method.
    public static Long getLastId() {
        return lastId;
    }

    //TODO: Why public static? It can be a private method.
    public static void increaseLastId(){
        lastId++;
        getLastIdCollection().put(ENTITY, lastId);
        setLastIdCollection(getLastIdCollection());
    }

    public static UserDaoImpl getInstance(){
        return  UserHolder.INSTANCE;
    }
    @Override
    public User persist(User element) {
        return null;
    }

    @Override
    public boolean remove(User element) {
        //TODO: Please, remove try block.
        try {
            //TODO: Please add check for null. If id is null the method should throw exception.
            long id = element.getId();
            //TODO: removeIf returns boolean. Please remove unnecessary check.
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
