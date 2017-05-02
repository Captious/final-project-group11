package ua.goit.java.hotelbooking.dao.impl;

import ua.goit.java.hotelbooking.dao.HotelDao;
import ua.goit.java.hotelbooking.dao.utils.DataSerialization;
import ua.goit.java.hotelbooking.model.Hotel;

import java.util.ArrayList;
import java.util.List;

public class HotelDaoImpl implements HotelDao{

    private List<Hotel> hotels;
    private static final String FILE_PATH = "FinalProject/src/main/java/ua/goit/java/hotelbooking/data/hotel.txt";

    private HotelDaoImpl(){
        hotels = (ArrayList<Hotel>) DataSerialization.deserializeData(FILE_PATH);
        if (hotels == null) hotels = new ArrayList<Hotel>();
    }

    private static class HotelHolder {
        private final static HotelDaoImpl instance = new HotelDaoImpl();
    }

    public static HotelDaoImpl getInstance(){
        return  HotelHolder.instance;
    }

    @Override
    public Hotel persist(Hotel element) {
        return null;
    }

    @Override
    public boolean remove(Hotel element) {
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
        return null;
    }
}
