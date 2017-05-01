package ua.goit.java.hotelbooking.services;

import ua.goit.java.hotelbooking.model.Hotel;
import ua.goit.java.hotelbooking.model.Room;

import java.util.List;

public interface HotelManageService extends ManageService<Hotel> {
    boolean remove(Hotel element);
    Hotel findByName(String name);
    List<Hotel> findByCity(String cityName);
    void addRoom(Hotel hotel, Room room);
    boolean removeRoom(Hotel hotel, Room room);
}
