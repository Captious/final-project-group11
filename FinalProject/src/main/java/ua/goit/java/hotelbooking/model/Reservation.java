package ua.goit.java.hotelbooking.model;

import java.util.Date;

public class Reservation {
    private Long id;
    private Room room;
    private Date reservationDate;
    private User user;

    public Reservation(Room room, Date reservationDate, User user) {
        this.room = room;
        this.reservationDate = reservationDate;
        this.user = user;
    }

    public Reservation(Long id, Room room, Date reservationDate, User user) {
        this.id = id;
        this.room = room;
        this.reservationDate = reservationDate;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
