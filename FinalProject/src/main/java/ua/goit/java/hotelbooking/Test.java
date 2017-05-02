package ua.goit.java.hotelbooking;

import ua.goit.java.hotelbooking.dao.HotelDao;
import ua.goit.java.hotelbooking.dao.ReservationDao;
import ua.goit.java.hotelbooking.dao.RoomDao;
import ua.goit.java.hotelbooking.dao.UserDao;
import ua.goit.java.hotelbooking.dao.impl.HotelDaoImpl;
import ua.goit.java.hotelbooking.dao.impl.ReservationDaoImpl;
import ua.goit.java.hotelbooking.dao.impl.RoomDaoImpl;
import ua.goit.java.hotelbooking.dao.impl.UserDaoImpl;

public class Test {
    public static void main(String[] args) {
        HotelDao dbHotel = HotelDaoImpl.getInstance();
        RoomDao dbRoom = RoomDaoImpl.getInstance();
        UserDao dbUser = UserDaoImpl.getInstance();
        ReservationDao dbReservation = ReservationDaoImpl.getInstance();
    }
}
