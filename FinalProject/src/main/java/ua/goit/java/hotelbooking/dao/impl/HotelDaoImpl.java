package ua.goit.java.hotelbooking.dao.impl;

import ua.goit.java.hotelbooking.dao.HotelDao;
import ua.goit.java.hotelbooking.model.Hotel;

import java.util.List;

public class HotelDaoImpl implements HotelDao{

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
