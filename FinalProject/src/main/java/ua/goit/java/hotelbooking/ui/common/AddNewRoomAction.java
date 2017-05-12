package ua.goit.java.hotelbooking.ui.common;

import ua.goit.java.hotelbooking.model.Hotel;
import ua.goit.java.hotelbooking.model.Room;

public class AddNewRoomAction extends AbstractHotelAction {

    @Override
    public void execute() {
        System.out.println("Select hotel.");
        Hotel hotel = commandLine.choose(hotelManageService.getAll());
        System.out.println("Input room number.");
        String roomNumber = getValidString();
        Room room = new Room(roomNumber, hotel);
        hotelManageService.addRoom(hotel, room);
    }

    @Override
    public String toString() {
        return "Insert new room.";
    }
}
