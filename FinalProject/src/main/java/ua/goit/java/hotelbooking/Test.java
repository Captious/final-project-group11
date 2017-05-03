package ua.goit.java.hotelbooking;

import ua.goit.java.hotelbooking.dao.HotelDao;
import ua.goit.java.hotelbooking.dao.ReservationDao;
import ua.goit.java.hotelbooking.dao.RoomDao;
import ua.goit.java.hotelbooking.dao.UserDao;
import ua.goit.java.hotelbooking.dao.impl.HotelDaoImpl;
import ua.goit.java.hotelbooking.dao.impl.ReservationDaoImpl;
import ua.goit.java.hotelbooking.dao.impl.RoomDaoImpl;
import ua.goit.java.hotelbooking.dao.impl.UserDaoImpl;
import ua.goit.java.hotelbooking.dao.utils.IdGenerator;
import ua.goit.java.hotelbooking.model.Hotel;

public class Test {
    public static void main(String[] args) {
        HotelDao dbHotel = HotelDaoImpl.getInstance();
        RoomDao dbRoom = RoomDaoImpl.getInstance();
        UserDao dbUser = UserDaoImpl.getInstance();
        ReservationDao dbReservation = ReservationDaoImpl.getInstance();

        Hotel h1 = new Hotel("Ramada", "Kiev");
        Hotel h2 = new Hotel("Ramada", "Dnepr");
        h1.setId(IdGenerator.generateId(h1));
        h2.setId(IdGenerator.generateId(h2));
        System.out.println(h1.getId());
        System.out.println(h2.getId());
    }
}
