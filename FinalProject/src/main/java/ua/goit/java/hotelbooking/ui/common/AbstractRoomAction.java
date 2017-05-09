package ua.goit.java.hotelbooking.ui.common;

import ua.goit.java.hotelbooking.services.HotelManageService;
import ua.goit.java.hotelbooking.services.RoomManageService;
import ua.goit.java.hotelbooking.services.impl.HotelManageServiceImpl;
import ua.goit.java.hotelbooking.services.impl.RoomManageServiceImpl;

public abstract class AbstractRoomAction extends ActionWithScanner {
    protected final HotelManageService hotelManageService;
    protected final RoomManageService roomManageService;

    public AbstractRoomAction() {
        hotelManageService = new HotelManageServiceImpl();
        roomManageService = new RoomManageServiceImpl();
    }
}
