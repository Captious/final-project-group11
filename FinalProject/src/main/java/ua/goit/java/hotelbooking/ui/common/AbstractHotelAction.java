package ua.goit.java.hotelbooking.ui.common;

import ua.goit.java.hotelbooking.services.HotelManageService;
import ua.goit.java.hotelbooking.services.impl.HotelManageServiceImpl;

public abstract class AbstractHotelAction extends ActionWithScanner {
    protected final HotelManageService hotelManageService;

    public AbstractHotelAction() {
        hotelManageService = new HotelManageServiceImpl();
    }
}
