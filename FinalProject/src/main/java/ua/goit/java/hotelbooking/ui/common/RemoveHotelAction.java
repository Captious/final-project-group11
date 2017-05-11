package ua.goit.java.hotelbooking.ui.common;

import ua.goit.java.hotelbooking.model.Hotel;

public class RemoveHotelAction extends AbstractHotelAction {
    @Override
    public void execute(CommandLine commandLine) {
        System.out.println("Select hotel:");
        Hotel hotel = commandLine.choose(hotelManageService.getAll());
        try {
            hotelManageService.remove(hotel);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Remove hotel.";
    }
}
