package ua.goit.java.hotelbooking.dao.impl;

import ua.goit.java.hotelbooking.dao.HotelDao;
import ua.goit.java.hotelbooking.dao.utils.DataSerialization;
import ua.goit.java.hotelbooking.model.Hotel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HotelDaoImpl extends BaseDaoImpl<Hotel> implements HotelDao {

    private static final String FILE_PATH =
            String.format("src/main/java/ua/goit/java/hotelbooking/data/hotel.txt",
                    System.getProperty("user.dir"));
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

    @Override
    protected Long getLastId() {
        return lastId;
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
    public Hotel persist(Hotel element) {
        List<Hotel> hotels = getAll();
        Long elementID = element.getId();
        if (elementID == null) {
            if (hotels.stream().anyMatch(h -> h.getName().toLowerCase().equals(element.getName().toLowerCase()))) {
                throw new RuntimeException("The hotel with the same name exists in the database");
            }
            increaseLastId();
            element.setId(getLastId());
            hotels.add(element);
        } else {
            boolean finding = false;
            for (int i = 0; i < hotels.size(); i++) {
                if (hotels.get(i).getId().equals(elementID)) {
                    hotels.set(i, element);
                    finding = true;
                    break;
                }
            }
            if (!finding) {
                throw new RuntimeException("There is no such hotel in database");
            }
        }
        DataSerialization.serializeData(getFilePath(), hotels);
        return element;
    }

    @Override
    public List<Hotel> getAll() {
        return (ArrayList<Hotel>) DataSerialization.deserializeData(FILE_PATH);
    }

    @Override
    public Hotel getByName(String name) {
        List<Hotel> answer;
        answer = this.getAll().stream()
                .filter(hotel -> hotel.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
        if (answer.size() > 1) {
            throw new RuntimeException("Hotels have copies.");
        }
        if (answer.size() == 0) {
            return null;
        } else
            return answer.get(0);
    }

    @Override
    public List<Hotel> getByCity(String city) {
        List<Hotel> answer = new ArrayList<>();
        getAll().forEach(x -> {
            if (x.getCity().toLowerCase().equals(city.toLowerCase())) answer.add(x);
        });
        return answer;
    }
}
