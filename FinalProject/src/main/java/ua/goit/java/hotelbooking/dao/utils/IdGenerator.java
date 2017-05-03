package ua.goit.java.hotelbooking.dao.utils;

import ua.goit.java.hotelbooking.model.IdManager;

public class IdGenerator {

    private IdGenerator(){}

    public static Long generateId(IdManager entity){
        return new Long(entity.hashCode());
    }
}
