package ua.goit.java.hotelbooking.ui.common;

import ua.goit.java.hotelbooking.model.Hotel;

public class RemoveHotelAction extends AbstractHotelAction {

    @Override
    public void execute() {
        System.out.println("Select hotel:");
        Hotel hotel = commandLine.choose(hotelManageService.getAll());
        hotelManageService.remove(hotel);
    }

    @Override
    public String toString() {
        return "Remove hotel.";
    }
}
