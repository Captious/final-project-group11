package ua.goit.java.hotelbooking;

import ua.goit.java.hotelbooking.data.prepared.data.Materials;
import ua.goit.java.hotelbooking.model.Hotel;
import ua.goit.java.hotelbooking.model.Reservation;
import ua.goit.java.hotelbooking.model.Room;
import ua.goit.java.hotelbooking.model.User;
import ua.goit.java.hotelbooking.services.impl.HotelManageServiceImpl;
import ua.goit.java.hotelbooking.services.impl.ReservationServiceImpl;
import ua.goit.java.hotelbooking.services.impl.RoomManageServiceImpl;
import ua.goit.java.hotelbooking.services.impl.UserManageServiceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) throws ParseException {
        resetAndViewData();
    }

    public static void resetAndViewData() {
        Materials materials = new Materials();
        materials.writePreparedData();

        HotelManageServiceImpl hotelManageService = new HotelManageServiceImpl();
        UserManageServiceImpl userManageService = new UserManageServiceImpl();
        ReservationServiceImpl reservationService = new ReservationServiceImpl();

        List<Room> rooms = hotelManageService.getRoomDao().getAll();
        List<Hotel> hotels = hotelManageService.getHotelDao().getAll();
        List<User> users = userManageService.getUserDao().getAll();
        List<Reservation> reservations = reservationService.getReservationDao().getAll();

        materials.addRoomsToHotels(hotels, rooms);

        System.out.println("Prepared data in the database.");
        System.out.println("\nHotels with rooms:");
        for (Hotel hotel: hotels) {
            System.out.printf("\nid: %-5d  %s rooms: ", hotel.getId(), hotel);
            for (Room room: hotel.getRooms()) {
                System.out.printf("(id:%-3d)%-4s", room.getId(), room.getNumber());
            }
        }
        System.out.println("\n\nUsers:");
        for (User user: users) {
            System.out.printf("\nid: %-5d  %s", user.getId(), user);
        }
        System.out.println("\n\nReservations:");
        for (Reservation reservation: reservations) {
            System.out.printf("\nid: %-5d  %s", reservation.getId(), reservation);
        }
        System.out.println();
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("All Hotels");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        hotelManageService.getHotelDao().getAll().forEach(System.out::println);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("All Hotels in Kiev");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        hotelManageService.getHotelDao().getByCity("Kiev").forEach(System.out::println);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Hilton hotel");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(hotelManageService.getHotelDao().getByName("Hilton"));
    }

}
