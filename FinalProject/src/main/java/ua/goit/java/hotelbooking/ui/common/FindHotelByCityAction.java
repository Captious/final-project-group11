package ua.goit.java.hotelbooking.ui.common;

import ua.goit.java.hotelbooking.model.Hotel;

import java.util.List;

public class FindHotelByCityAction extends AbstractHotelAction {

    @Override
    public void execute() {
        System.out.println("Input city name for search:");
        String cityName = getValidString();
        List<Hotel> hotels = hotelManageService.findByCity(cityName);
        System.out.printf("Find hotels:\n %s \n", hotels);
    }

    @Override
    public String toString() {
        return "Find hotel by city.";
    }
}
