package ua.goit.java.hotelbooking.model;

import java.io.Serializable;
import java.util.Date;

public class Reservation implements Serializable {
    private Long id;
    private Room room;
    private Date reservationDate;
    private User user;

    public Reservation(Room room, Date reservationDate) {
        this.room = room;
        this.reservationDate = reservationDate;
    }

    public Reservation(Room room, Date reservationDate, User user) {
        this.room = room;
        this.reservationDate = reservationDate;
        this.user = user;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reservation that = (Reservation) o;

        if (!getRoom().equals(that.getRoom())) return false;
        return getReservationDate().equals(that.getReservationDate());
    }

    @Override
    public int hashCode() {
        int result = getRoom().hashCode();
        result = 31 * result + getReservationDate().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return String.format("hotel: %-15s room: %-5s date: %td-%tm-%tY  user: %-30s ",
                this.getRoom().getHotel().getName(), this.getRoom().getNumber(),
                this.getReservationDate(), this.getReservationDate(), this.getReservationDate(),
                this.getUser().getFio());
    }
}
