package ua.goit.java.hotelbooking.ui.common;

import ua.goit.java.hotelbooking.model.Hotel;

public class FindHotelByNameAction extends AbstractHotelAction {
    @Override
    public void execute(CommandLine commandLine) {
        System.out.println("Input city name for search:");
        String hotelCity = getValidString();
        System.out.println("Input hotel name for search:");
        String hotelName = getValidString();

        Hotel hotel = hotelManageService.findByName(hotelName,hotelCity);
        System.out.printf("Find hotel:\n %s \n", hotel);
    }

    @Override
    public String toString() {
        return "Find hotel by name.";
    }
}
