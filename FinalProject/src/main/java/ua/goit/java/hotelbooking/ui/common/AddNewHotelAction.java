package ua.goit.java.hotelbooking.ui.common;

import ua.goit.java.hotelbooking.model.Hotel;

public class AddNewHotelAction extends AbstractHotelAction {

    @Override
    public void execute() {
        System.out.println("Input hotel name:");
        String hotelName = getValidString();
        System.out.println("Input hotel city:");
        String hotelCity = getValidString();
        Hotel hotel = new Hotel(hotelName, hotelCity);
        hotelManageService.add(hotel);
    }

    @Override
    public String toString() {
        return "Insert new hotel.";
    }
}
