package ua.goit.java.hotelbooking.ui.common;

import ua.goit.java.hotelbooking.model.Hotel;

public class AddNewHotelAction extends AbstractHotelAction {

    @Override
    public void execute(CommandLine commandLine) {
        System.out.println("Input hotel name:");
        String hotelName = scanner.nextLine();
        System.out.println("Input hotel city:");
        String hotelCity = scanner.nextLine();
        Hotel hotel = new Hotel(hotelName, hotelCity);
        hotelManageService.add(hotel);
    }

    @Override
    public String toString() {
        return "Insert new hotel.";
    }
}
