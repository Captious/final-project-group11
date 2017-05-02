package ua.goit.java.hotelbooking.services.impl;

import ua.goit.java.hotelbooking.model.Hotel;
import ua.goit.java.hotelbooking.model.Room;
import ua.goit.java.hotelbooking.services.HotelManageService;

import java.util.List;

public class HotelManageServiceImpl implements HotelManageService {

    @Override
    public void add(Hotel element) {

    }

    @Override
    public Hotel edit(Hotel element) {
        return null;
    }

    @Override
    public boolean remove(Hotel element) {
        return false;
    }

    @Override
    public Hotel findByName(String name) {
        return null;
    }

    @Override
    public List<Hotel> findByCity(String cityName) {
        return null;
    }

    @Override
    public void addRoom(Hotel hotel, Room room) {

    }

    @Override
    public boolean removeRoom(Hotel hotel, Room room) {
        return false;
    }
}
