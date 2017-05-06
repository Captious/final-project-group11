package ua.goit.java.hotelbooking.dao.impl;

import ua.goit.java.hotelbooking.dao.HotelDao;
import ua.goit.java.hotelbooking.dao.utils.DataSerialization;
import ua.goit.java.hotelbooking.model.Hotel;

import java.util.ArrayList;
import java.util.List;

public class HotelDaoImpl extends IdCollectionHolder implements HotelDao {

    private List<Hotel> hotels;
    private static final String FILE_PATH = "FinalProject/src/main/java/ua/goit/java/hotelbooking/data/hotel.txt";
    private static final String ENTITY = "Hotel";
    private static Long lastId;

    private HotelDaoImpl() {
        super();
        hotels = (ArrayList<Hotel>) DataSerialization.deserializeData(FILE_PATH);
        lastId = getLastIdCollection().get(ENTITY);
    }

    private static class HotelHolder {
        private final static HotelDaoImpl INSTANCE = new HotelDaoImpl();
    }

    public static HotelDaoImpl getInstance() {
        return HotelHolder.INSTANCE;
    }

    public static Long getLastId() {
        return lastId;
    }

    public static void increaseLastId() {
        lastId++;
        getLastIdCollection().put(ENTITY, lastId);
        setLastIdCollection(getLastIdCollection());
    }

    @Override
    public Hotel persist(Hotel element) {

        Long elementID = element.getId();
        if (elementID == null){
            this.increaseLastId();
            element.setId(this.lastId);
            hotels.add(element);
        } else{

            boolean finding = false;
            for (int i = 0; i < hotels.size(); i++) {
                if (hotels.get(i).getId() == elementID){
                    hotels.set(i,element);
                    finding = true;
                    break;
                }
            }

            if (!finding){
                new RuntimeException("There is no such hotel in database");
            }
        }
        DataSerialization.serializeData(FILE_PATH, hotels);
        return element;
    }

    @Override
    public boolean remove(Hotel element) {
        //TODO: Please, remove try block.
        try {
            //TODO: Please add check for null. If id is null the method should throw exception.
            long id = element.getId();
            //TODO: removeIf returns boolean. Please remove unnecessary check.
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
        //TODO: String values are not comparing by `==`. Please use for that `equals()`.
        hotels.forEach(x ->{if(x.getCity() == city) answer.add(x);});
        return answer;
    }

}
