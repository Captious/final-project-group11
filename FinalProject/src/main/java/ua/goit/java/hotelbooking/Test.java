package ua.goit.java.hotelbooking;

import ua.goit.java.hotelbooking.dao.HotelDao;
import ua.goit.java.hotelbooking.dao.ReservationDao;
import ua.goit.java.hotelbooking.dao.RoomDao;
import ua.goit.java.hotelbooking.dao.UserDao;
import ua.goit.java.hotelbooking.dao.impl.HotelDaoImpl;
import ua.goit.java.hotelbooking.dao.impl.ReservationDaoImpl;
import ua.goit.java.hotelbooking.dao.impl.RoomDaoImpl;
import ua.goit.java.hotelbooking.dao.impl.UserDaoImpl;
import ua.goit.java.hotelbooking.dao.utils.DataSerialization;

import java.util.Map;

public class Test {
    public static void main(String[] args) {
        HotelDao dbHotel = HotelDaoImpl.getInstance();
        RoomDao dbRoom = RoomDaoImpl.getInstance();
        UserDao dbUser = UserDaoImpl.getInstance();
        ReservationDao dbReservation = ReservationDaoImpl.getInstance();

        String path = "FinalProject/src/main/java/ua/goit/java/hotelbooking/data/id.txt";
        Map<String, Long> idCount;
        HotelDaoImpl.increaseLastId();
        RoomDaoImpl.increaseLastId();
        idCount = (Map<String, Long>) DataSerialization.deserializeData(path);
        System.out.println(idCount.get("Hotel"));
        System.out.println(idCount.get("Room"));
        idCount.put("Hotel", new Long(0));
        idCount.put("Room", new Long(0));
        DataSerialization.serializeData(path, idCount);
        idCount = (Map<String, Long>) DataSerialization.deserializeData(path);
        System.out.println(idCount.get("Hotel"));
        System.out.println(idCount.get("Room"));

    }
}
