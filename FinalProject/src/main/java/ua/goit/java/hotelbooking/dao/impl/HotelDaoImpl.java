package ua.goit.java.hotelbooking.dao.impl;

import ua.goit.java.hotelbooking.dao.HotelDao;
import ua.goit.java.hotelbooking.dao.utils.DataSerialization;
import ua.goit.java.hotelbooking.model.Hotel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HotelDaoImpl extends BaseDaoImpl<Hotel> implements HotelDao {

    private static final String FILE_PATH =
            String.format("%s/src/main/java/ua/goit/java/hotelbooking/data/hotel.txt",
                    System.getProperty("user.dir"));
    private static final String ENTITY = "Hotel";

    private HotelDaoImpl() {
        super(ENTITY);
    }

    private static class HotelHolder {
        private final static HotelDaoImpl INSTANCE = new HotelDaoImpl();
    }

    public static HotelDaoImpl getInstance() {
        return HotelHolder.INSTANCE;
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
