package ua.goit.java.hotelbooking.dao.impl;

import ua.goit.java.hotelbooking.dao.HotelDao;
import ua.goit.java.hotelbooking.dao.utils.DataSerialization;
import ua.goit.java.hotelbooking.model.Hotel;

import java.util.ArrayList;
import java.util.List;

public class HotelDaoImpl extends IdCollectionHolder implements HotelDao {

    private static final String FILE_PATH = "FinalProject/src/main/java/ua/goit/java/hotelbooking/data/hotel.txt";
    private static final String ENTITY = "Hotel";
    private static Long lastId;

    private HotelDaoImpl() {
        super();
        lastId = getLastIdCollection().get(ENTITY);
    }

    private static class HotelHolder {
        private final static HotelDaoImpl INSTANCE = new HotelDaoImpl();
    }

    public static HotelDaoImpl getInstance() {
        return HotelHolder.INSTANCE;
    }

    private Long getLastId() {
        return lastId;
    }

    private void increaseLastId() {
        lastId++;
        getLastIdCollection().put(ENTITY, lastId);
        setLastIdCollection(getLastIdCollection());
    }

    @Override
    public Hotel persist(Hotel element) {

        getAll();
        Long elementID = element.getId();
        if (elementID == null){
            this.increaseLastId();
            element.setId(this.lastId);
            //TODO: Don't use this List. Create local variable for that and use it. (Initialize local variable by calling `getAll()` method)
            hotels.add(element);
        } else{

            boolean finding = false;
            for (int i = 0; i < hotels.size(); i++) {
                //TODO: Any objects are not comparing by `==`. Please, use for this `equals()`
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
        long id = element.getId();
        if(Long.valueOf(id) == null){
            throw new RuntimeException("There is no such hotel in database");
        }
        if((getAll().removeIf(x -> x.getId() == id) == true)) {
            DataSerialization.serializeData(FILE_PATH, getAll());
            return true;
        }
        return false;
    }

    @Override
    public List<Hotel> getAll() {
        return (ArrayList<Hotel>) DataSerialization.deserializeData(FILE_PATH);
    }

    @Override
    public Hotel getByName(String name) {
        return null;
    }

    @Override
    public List<Hotel> getByCity(String city) {
        List<Hotel> answer = new ArrayList<>();
        //TODO: String values are not comparing by `==`. Please use for that `equals()`.
        getAll().forEach(x ->{if(x.getCity() == city) answer.add(x);});
        return answer;
    }

}
