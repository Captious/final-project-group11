package ua.goit.java.hotelbooking.ui.common;

import ua.goit.java.hotelbooking.model.Hotel;

public class EditHotelAction extends AbstractHotelAction {
    @Override
    public void execute(CommandLine commandLine) {
        System.out.println("Select hotel:");
        Hotel hotel = commandLine.choose(hotelManageService.getAll());
        System.out.println("Input new hotel name:");
        String hotelName = getValidString();
        System.out.println("Input new hotel city:");
        String hotelCity = getValidString();
        hotel.setName(hotelName);
        hotel.setCity(hotelCity);
        try {
            hotelManageService.edit(hotel);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Edit hotel.";
    }
}
