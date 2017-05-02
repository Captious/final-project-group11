package ua.goit.java.hotelbooking.model;

import java.io.Serializable;

public class Room implements Serializable{
    private Long id;
    private String number;
    Hotel hotel;

    public Room(String number, Hotel hotel) {
        this.number = number;
        this.hotel = hotel;
    }

    public Room(Long id, String number, Hotel hotel) {
        this.id = id;
        this.number = number;
        this.hotel = hotel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
