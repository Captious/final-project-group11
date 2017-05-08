package ua.goit.java.hotelbooking.dao.impl;

import ua.goit.java.hotelbooking.dao.UserDao;
import ua.goit.java.hotelbooking.dao.utils.DataSerialization;
import ua.goit.java.hotelbooking.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class UserDaoImpl extends IdCollectionHolder implements UserDao {

    private static final String FILE_PATH = "FinalProject/src/main/java/ua/goit/java/hotelbooking/data/user.txt";
    private static final String ENTITY = "User";
    private static Long lastId;

    private UserDaoImpl() {
        super();
        lastId = getLastIdCollection().get(ENTITY);
    }

    private static class UserHolder {
        private final static UserDaoImpl INSTANCE = new UserDaoImpl();
    }

    public static UserDaoImpl getInstance(){
        return  UserHolder.INSTANCE;
    }

    private Long getLastId() {
        return lastId;
    }

    private void increaseLastId(){
        lastId++;
        getLastIdCollection().put(ENTITY, lastId);
        setLastIdCollection(getLastIdCollection());
    }

    @Override
    public User persist(User element) {
        List<User> userList = getAll();
        if (element.getId() == null){
            increaseLastId();
            element.setId(getLastId());
            userList.add(element);
        } else {
            try {
                int index = IntStream.range(0, userList.size())
                        .filter(i -> element.getId().equals(userList.get(i).getId()))
                        .findFirst()
                        .getAsInt();
                userList.set(index, element);
            } catch (RuntimeException exception) {
                throw new RuntimeException(String.format("There is no element with that ID (%d) in the database %s",
                        element.getId(), ENTITY));
            }
        }
        DataSerialization.serializeData(FILE_PATH, userList);
        return element;
    }

    @Override
    public boolean remove(User element) {
        List<User> users = getAll();
        Long id = element.getId();
        if(id == null){
            throw new RuntimeException("There is no such hotel in database");
        }
        if((users.removeIf(x -> x.getId().equals(id)))) {
            DataSerialization.serializeData(FILE_PATH, users);
            return true;
        }
        return false;
    }

    @Override
    public List<User> getAll() {
        return (ArrayList<User>) DataSerialization.deserializeData(FILE_PATH);
    }
}
