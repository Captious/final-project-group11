package ua.goit.java.hotelbooking.dao;

import ua.goit.java.hotelbooking.model.Hotel;

import java.util.List;

public interface HotelDao extends BaseDao<Hotel> {
    Hotel getByName(String name);
    List<Hotel> getByCity(String city);
}
