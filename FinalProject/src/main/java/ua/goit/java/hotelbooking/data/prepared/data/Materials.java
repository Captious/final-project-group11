package ua.goit.java.hotelbooking.data.prepared.data;

import ua.goit.java.hotelbooking.dao.*;
import ua.goit.java.hotelbooking.dao.impl.HotelDaoImpl;
import ua.goit.java.hotelbooking.dao.impl.ReservationDaoImpl;
import ua.goit.java.hotelbooking.dao.impl.RoomDaoImpl;
import ua.goit.java.hotelbooking.dao.impl.UserDaoImpl;
import ua.goit.java.hotelbooking.dao.utils.DataSerialization;
import ua.goit.java.hotelbooking.model.Hotel;
import ua.goit.java.hotelbooking.model.Reservation;
import ua.goit.java.hotelbooking.model.Room;
import ua.goit.java.hotelbooking.model.User;
import ua.goit.java.hotelbooking.services.HotelManageService;
import ua.goit.java.hotelbooking.services.impl.HotelManageServiceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Materials {

    private Map<String, Long> ids;
    private List<Hotel> hotels;
    private List<Room> rooms;
    private List<User> users;
    private List<Reservation> reservations;

    public Materials() {
        hotels = new ArrayList<>();
        rooms = new ArrayList<>();
        users = new ArrayList<>();
        reservations = new ArrayList<>();
        ids = new HashMap<>();
        ids.put("Hotel", new Long(0));
        ids.put("Room", new Long(0));
        ids.put("User", new Long(0));
        ids.put("Reservation", new Long(0));
    }

    private void setHotels() {
        hotels.add(new Hotel("Hilton", "Kiev"));
        hotels.add(new Hotel("Diplomat", "Kiev"));
        hotels.add(new Hotel("Avrora", "Kharkiv"));
        hotels.add(new Hotel("Viva", "Kharkiv"));
        hotels.add(new Hotel("Academy", "Dnepr"));
        hotels.add(new Hotel("Bon", "Dnepr"));
    }

    private void setRooms() {
        rooms.add(new Room("1A", hotels.get(0)));
        rooms.add(new Room("2A", hotels.get(0)));
        rooms.add(new Room("3A", hotels.get(0)));
        rooms.add(new Room("4A", hotels.get(0)));
        rooms.add(new Room("5A", hotels.get(0)));
        rooms.add(new Room("6A", hotels.get(0)));
        rooms.add(new Room("7A", hotels.get(0)));
        rooms.add(new Room("8A", hotels.get(0)));
        rooms.add(new Room("9A", hotels.get(0)));
        rooms.add(new Room("10A", hotels.get(0)));
        rooms.add(new Room("11", hotels.get(1)));
        rooms.add(new Room("12", hotels.get(1)));
        rooms.add(new Room("13", hotels.get(1)));
        rooms.add(new Room("14", hotels.get(1)));
        rooms.add(new Room("15", hotels.get(1)));
        rooms.add(new Room("16", hotels.get(1)));
        rooms.add(new Room("17", hotels.get(1)));
        rooms.add(new Room("18", hotels.get(1)));
        rooms.add(new Room("19", hotels.get(1)));
        rooms.add(new Room("20", hotels.get(1)));
        rooms.add(new Room("1B", hotels.get(2)));
        rooms.add(new Room("2B", hotels.get(2)));
        rooms.add(new Room("3B", hotels.get(2)));
        rooms.add(new Room("4B", hotels.get(2)));
        rooms.add(new Room("5B", hotels.get(2)));
        rooms.add(new Room("6B", hotels.get(2)));
        rooms.add(new Room("7B", hotels.get(2)));
        rooms.add(new Room("8B", hotels.get(2)));
        rooms.add(new Room("9B", hotels.get(2)));
        rooms.add(new Room("10B", hotels.get(2)));
        rooms.add(new Room("1", hotels.get(3)));
        rooms.add(new Room("2", hotels.get(3)));
        rooms.add(new Room("3", hotels.get(3)));
        rooms.add(new Room("4", hotels.get(3)));
        rooms.add(new Room("5", hotels.get(3)));
        rooms.add(new Room("6", hotels.get(3)));
        rooms.add(new Room("7", hotels.get(3)));
        rooms.add(new Room("8", hotels.get(3)));
        rooms.add(new Room("9", hotels.get(3)));
        rooms.add(new Room("10", hotels.get(3)));
        rooms.add(new Room("1C", hotels.get(4)));
        rooms.add(new Room("2C", hotels.get(4)));
        rooms.add(new Room("3C", hotels.get(4)));
        rooms.add(new Room("4C", hotels.get(4)));
        rooms.add(new Room("5C", hotels.get(4)));
        rooms.add(new Room("6C", hotels.get(4)));
        rooms.add(new Room("7C", hotels.get(4)));
        rooms.add(new Room("8C", hotels.get(4)));
        rooms.add(new Room("9C", hotels.get(4)));
        rooms.add(new Room("10C", hotels.get(4)));
        rooms.add(new Room("101", hotels.get(5)));
        rooms.add(new Room("102", hotels.get(5)));
        rooms.add(new Room("103", hotels.get(5)));
        rooms.add(new Room("104", hotels.get(5)));
        rooms.add(new Room("105", hotels.get(5)));
        rooms.add(new Room("106", hotels.get(5)));
        rooms.add(new Room("107", hotels.get(5)));
        rooms.add(new Room("108", hotels.get(5)));
        rooms.add(new Room("109", hotels.get(5)));
        rooms.add(new Room("110", hotels.get(5)));
    }

    private void setUsers() {
        users.add(new User("Sergey Petrov","Petrov"));
        users.add(new User("Irina Drozd","Drozd"));
        users.add(new User("Maksim Mironov","Mironov"));
        users.add(new User("Oleg Kovalenko","Kovalenko"));
        users.add(new User("Marina Talalay","Talalay"));
    }

    private void setReservation() throws ParseException {
        reservations.add(new Reservation(rooms.get(1),
                (new SimpleDateFormat("dd-MM-yyyy")).parse("12-05-2017"), users.get(0)));
        reservations.add(new Reservation(rooms.get(2),
                (new SimpleDateFormat("dd-MM-yyyy")).parse("15-05-2017"), users.get(1)));
    }

    public void writePreparedData() {
        DataSerialization.serializeData("src/main/java/ua/goit/java/hotelbooking/data/id.txt", ids);
        DataSerialization.serializeData("src/main/java/ua/goit/java/hotelbooking/data/hotel.txt", hotels);
        DataSerialization.serializeData("src/main/java/ua/goit/java/hotelbooking/data/room.txt", rooms);
        DataSerialization.serializeData("src/main/java/ua/goit/java/hotelbooking/data/user.txt", users);
        DataSerialization.serializeData("src/main/java/ua/goit/java/hotelbooking/data/reservation.txt", reservations);
        HotelDao hotelDao = HotelDaoImpl.getInstance();
        RoomDao roomDao = RoomDaoImpl.getInstance();
        UserDao userDao = UserDaoImpl.getInstance();
        ReservationDao reservationDao = ReservationDaoImpl.getInstance();
        HotelManageService hotelManageService = new HotelManageServiceImpl();

        this.setHotels();
        this.setRooms();
        this.setUsers();
        try {
            this.setReservation();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for (Hotel hotel: hotels) {
            hotelDao.persist(hotel);
        }
        List<Hotel> hotels = hotelDao.getAll();
        for (Room room: rooms) {
            hotelManageService.addRoom(hotels.stream().filter(h -> h.equals(room.getHotel()))
                    .findFirst().get(), room);
        }
        for (User user: users) {
            userDao.persist(user);
        }
        for (Reservation reservation: reservations) {
            reservationDao.persist(reservation);
        }
    }

    public void addRoomsToHotels(List<Hotel> hotels, List<Room> rooms) {
        HotelManageService hotelManageService = new HotelManageServiceImpl();
        try {
            for (Room room : rooms) {
                hotelManageService.addRoom(hotels.get(hotels.indexOf(room.getHotel())), room);
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
