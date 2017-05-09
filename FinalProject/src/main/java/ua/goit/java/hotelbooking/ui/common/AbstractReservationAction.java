package ua.goit.java.hotelbooking.ui.common;

import ua.goit.java.hotelbooking.services.ReservationService;
import ua.goit.java.hotelbooking.services.RoomManageService;
import ua.goit.java.hotelbooking.services.UserManageService;
import ua.goit.java.hotelbooking.services.impl.ReservationServiceImpl;
import ua.goit.java.hotelbooking.services.impl.RoomManageServiceImpl;
import ua.goit.java.hotelbooking.services.impl.UserManageServiceImpl;

public abstract class AbstractReservationAction extends ActionWithScanner {
    protected final ReservationService reservationService;
    protected final UserManageService userManageService;
    protected final RoomManageService roomManageService;

    public AbstractReservationAction() {
        reservationService = new ReservationServiceImpl();
        userManageService = new UserManageServiceImpl();
        roomManageService = new RoomManageServiceImpl();
    }
}
