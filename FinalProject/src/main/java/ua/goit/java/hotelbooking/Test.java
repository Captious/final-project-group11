package ua.goit.java.hotelbooking;

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

        Hotel hotelTemp = new Hotel("Test","Test");
        List<Room> roomList = new ArrayList<>();
        Room r1 = new Room("200",hotelTemp);
        Room r2 = new Room("250",hotelTemp);
        Room r3 = new Room("300",hotelTemp);
        Room r4 = new Room("350",hotelTemp);
        Room r5 = new Room("400",hotelTemp);
        roomList.addAll(Arrays.asList(r1,r2,r3,r4,r5));

        Hotel hotel3 = new Hotel("Test1","Test1");
        Hotel hotel2 = new Hotel("Test2","Test2");
        Hotel hotel1 = new Hotel("Halchion","London",roomList);

        try{
            hotelManageService.add(hotel3);
            hotelManageService.add(hotel2);
            hotelManageService.add(hotel1);

            hotelManageService.addRoom(hotel2,r3);
            roomManageService.add(r3);

        } catch (RuntimeException exception) {}

        userManageService.add(new User("Bill Gates"));

        reservationService.add((rooms.get(4)),
                (new SimpleDateFormat("dd-MM-yyyy")).parse("25-03-2017"), users.get(4));


        hotelManageService.remove(hotelManageService.findByName("Test1"));

        hotelManageService.removeRoom(hotel2,r3);// не работает
        hotelManageService.removeRoom(hotelManageService.findByName("Halchion"),r3);// не работает

        System.out.println("\nSearch room by hotel");
        System.out.println(roomManageService.findByHotel(rooms.get(4),hotelManageService.findByName("Hilton")));

        System.out.println("\nSearch hotel by name:");
        System.out.println(hotelManageService.findByName("Hilton"));

        System.out.println("\nSearch hotel by city:");
        System.out.println(hotelManageService.findByCity("Kharkiv"));
    }
}
