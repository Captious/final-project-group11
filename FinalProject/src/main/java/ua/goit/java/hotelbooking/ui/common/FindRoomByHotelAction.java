package ua.goit.java.hotelbooking.ui.common;

import ua.goit.java.hotelbooking.model.Hotel;
import ua.goit.java.hotelbooking.model.Room;

public class FindRoomByHotelAction extends AbstractRoomAction {

    @Override
    public void execute() {
        System.out.println("Select hotel:");
        Hotel hotel = commandLine.choose(hotelManageService.getAll());
        System.out.println("Input room number:");
        String roomNumber = getValidString();
        Room room = new Room(roomNumber);
        Room foundRoom = roomManageService.findByHotel(room, hotel);
        if (foundRoom != null) {
            System.out.printf("Found room is: %s\n", foundRoom);
        } else {
            System.out.println("Room not found.");
        }
    }

    @Override
    public String toString() {
        return "Find room by hotel.";
    }
}
