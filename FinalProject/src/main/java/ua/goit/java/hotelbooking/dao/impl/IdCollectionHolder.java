package ua.goit.java.hotelbooking.dao.impl;

import ua.goit.java.hotelbooking.dao.utils.DataSerialization;

import java.util.Map;

public abstract class IdCollectionHolder {

    private static final String LAST_ID_PATH =
            String.format("%s/src/main/java/ua/goit/java/hotelbooking/data/id.txt",
                    System.getProperty("user.dir"));
    private static Map<String, Long> lastIdCollection;

    IdCollectionHolder(){
        lastIdCollection = (Map<String, Long>) DataSerialization.deserializeData(LAST_ID_PATH);
    }

    public static Map<String, Long> getLastIdCollection() {
        return lastIdCollection;
    }

    public static void setLastIdCollection(Map<String, Long> lastIdCollection) {
        IdCollectionHolder.lastIdCollection = lastIdCollection;
        DataSerialization.serializeData(LAST_ID_PATH, IdCollectionHolder.lastIdCollection);
    }
}
