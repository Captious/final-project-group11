package ua.goit.java.hotelbooking.ui.common;

import ua.goit.java.hotelbooking.model.Hotel;
import ua.goit.java.hotelbooking.model.Room;

public class AddNewRoomAction extends AbstractHotelAction {
    @Override
    public void execute(CommandLine commandLine) {
        System.out.println("Select hotel.");
        Hotel hotel = commandLine.choose(hotelManageService.getAll());
        System.out.println("Input room number.");
        String roomNumber = getValidString();
        Room room = new Room(roomNumber, hotel);
        try {
            hotelManageService.addRoom(hotel, room);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Insert new room.";
    }
}
