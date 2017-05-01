package ua.goit.java.hotelbooking.services;

import ua.goit.java.hotelbooking.model.Hotel;
import ua.goit.java.hotelbooking.model.Room;

public interface RoomManageService extends ManageService {
    Room findByHotel(Room room, Hotel hotel);
}
