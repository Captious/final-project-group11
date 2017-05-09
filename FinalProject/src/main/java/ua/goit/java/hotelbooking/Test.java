package ua.goit.java.hotelbooking;

import ua.goit.java.hotelbooking.model.Hotel;
import ua.goit.java.hotelbooking.model.Reservation;
import ua.goit.java.hotelbooking.model.Room;
import ua.goit.java.hotelbooking.model.User;
import ua.goit.java.hotelbooking.services.HotelManageService;
import ua.goit.java.hotelbooking.services.ReservationService;
import ua.goit.java.hotelbooking.services.RoomManageService;
import ua.goit.java.hotelbooking.services.UserManageService;
import ua.goit.java.hotelbooking.services.impl.HotelManageServiceImpl;
import ua.goit.java.hotelbooking.services.impl.ReservationServiceImpl;
import ua.goit.java.hotelbooking.services.impl.RoomManageServiceImpl;
import ua.goit.java.hotelbooking.services.impl.UserManageServiceImpl;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        HotelManageServiceImpl hotelManageService = new HotelManageServiceImpl();
        RoomManageServiceImpl roomManageService = new RoomManageServiceImpl();
        UserManageServiceImpl userManageService = new UserManageServiceImpl();
        ReservationServiceImpl reservationService = new ReservationServiceImpl();

        List<Room> rooms = hotelManageService.getRoomDao().getAll();
        List<Hotel> hotels = hotelManageService.getHotelDao().getAll();
        List<User> users = userManageService.getUserDao().getAll();
        List<Reservation> reservations = reservationService.getReservationDao().getAll();

        System.out.println("Prepared data in the database.");
        System.out.println("\nHotels with rooms:");
        for (Hotel hotel: hotels) {
            System.out.printf("\nid: %-5d  %s rooms: ", hotel.getId(), hotel);
            for (Room room: hotel.getRooms()) {
                System.out.printf("%-4s", room.getNumber());
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


    }
}
