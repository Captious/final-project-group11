package ua.goit.java.hotelbooking.dao.impl;

import ua.goit.java.hotelbooking.dao.HotelDao;
import ua.goit.java.hotelbooking.dao.utils.DataSerialization;
import ua.goit.java.hotelbooking.model.Hotel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HotelDaoImpl extends IdCollectionHolder implements HotelDao {

    private List<Hotel> hotels;
    private static final String FILE_PATH = "FinalProject/src/main/java/ua/goit/java/hotelbooking/data/hotel.txt";
    private static final String entity = "Hotel";
    private static Long lastId;

    private HotelDaoImpl() {
        super();
        hotels = (ArrayList<Hotel>) DataSerialization.deserializeData(FILE_PATH);
        lastId = getLastIdCollection().get(entity);
    }

    private static class HotelHolder {
        private final static HotelDaoImpl instance = new HotelDaoImpl();
    }

    public static HotelDaoImpl getInstance() {
        return HotelHolder.instance;
    }

    public static Long getLastId() {
        return lastId;
    }

    public static void increaseLastId() {
        lastId++;
        getLastIdCollection().put(entity, lastId);
        setLastIdCollection(getLastIdCollection());
    }

    @Override
    public Hotel persist(Hotel element) {
        return null;
    }

    @Override
    public boolean remove(Hotel element) {
        try {
            long id = element.getId();
            if((hotels.removeIf(x -> x.getId() == id) == true)){
                DataSerialization.serializeData(FILE_PATH, hotels);
                return true;
            }
        } catch (RuntimeException exception) {
            System.out.println("There is no such hotel in database");
        }
        return false;
    }

    @Override
    public List<Hotel> getAll() {
        return null;
    }

    @Override
    public Hotel getByName(String name) {
        return null;
    }

    @Override
    public List<Hotel> getByCity(String city) {
        List<Hotel> answer = new ArrayList<>();
        hotels.forEach(x ->{if(x.getCity() == city) answer.add(x);});
        return answer;
    }

}
