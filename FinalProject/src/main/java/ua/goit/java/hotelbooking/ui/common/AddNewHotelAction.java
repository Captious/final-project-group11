package ua.goit.java.hotelbooking.ui.common;

import ua.goit.java.hotelbooking.model.Hotel;

public class AddNewHotelAction extends AbstractHotelAction {

    @Override
    public void execute(CommandLine commandLine) {
        System.out.println("Input hotel name:");
        String hotelName = getValidString();
        System.out.println("Input hotel city:");
        String hotelCity = getValidString();
        Hotel hotel = new Hotel(hotelName, hotelCity);
        try {
            hotelManageService.add(hotel);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Insert new hotel.";
    }
}
