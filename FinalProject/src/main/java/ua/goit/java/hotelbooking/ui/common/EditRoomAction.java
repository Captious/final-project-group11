package ua.goit.java.hotelbooking.ui.common;

import ua.goit.java.hotelbooking.model.Hotel;
import ua.goit.java.hotelbooking.model.Room;
import ua.goit.java.hotelbooking.services.RoomManageService;
import ua.goit.java.hotelbooking.services.impl.RoomManageServiceImpl;

public class EditRoomAction extends AbstractHotelAction {
    private final RoomManageService roomManageService;

    public EditRoomAction() {
        roomManageService = new RoomManageServiceImpl();
    }


    @Override
    public void execute() {
        System.out.println("Select hotel:");
        Hotel hotel = commandLine.choose(hotelManageService.getAll());
        System.out.println("Select room:");
        Room room = commandLine.choose(hotel.getRooms());
        System.out.println("Input new room number:");
        String roomNumber = getValidString();
        room.setNumber(roomNumber);
        roomManageService.edit(room);
    }

    @Override
    public String toString() {
        return "Edit room.";
    }
}
