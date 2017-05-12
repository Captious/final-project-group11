package ua.goit.java.hotelbooking.ui.common;

import ua.goit.java.hotelbooking.model.Hotel;
import ua.goit.java.hotelbooking.model.Room;

public class RemoveRoomAction extends AbstractHotelAction {

    @Override
    public void execute() {
        System.out.println("Select hotel:");
        Hotel hotel = commandLine.choose(hotelManageService.getAll());
        System.out.println("select room:");
        Room room = commandLine.choose(hotel.getRooms());
        hotelManageService.removeRoom(hotel, room);
    }

    @Override
    public String toString() {
        return "Remove room.";
    }
}
