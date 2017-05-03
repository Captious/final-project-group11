package ua.goit.java.hotelbooking.model;

import java.io.Serializable;

public class Room implements Serializable, IdManager{
    private Long id;
    private String number;
    Hotel hotel;

    public Room(String number, Hotel hotel) {
        this.number = number;
        this.hotel = hotel;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        if (!getNumber().equals(room.getNumber())) return false;
        return getHotel().equals(room.getHotel());
    }

    @Override
    public int hashCode() {
        int result = getNumber().hashCode();
        result = 31 * result + getHotel().hashCode();
        return result;
    }
}
