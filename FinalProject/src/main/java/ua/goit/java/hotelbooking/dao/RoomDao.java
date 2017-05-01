package ua.goit.java.hotelbooking.dao;

import ua.goit.java.hotelbooking.model.Room;

public interface RoomDao extends BaseDao<Room> {
    Room getByHotel(String roomNumber, Long hotelId);
}
