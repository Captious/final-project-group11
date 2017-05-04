package ua.goit.java.hotelbooking.model;

import java.io.Serializable;
import java.util.List;

public class Hotel implements Serializable {
    private Long id;
    private String name;
    private String city;
    private List<Room> rooms;

    public Hotel(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public Hotel(String name, String city, List<Room> rooms) {
        this.name = name;
        this.city = city;
        this.rooms = rooms;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
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

        Hotel hotel = (Hotel) o;

        if (!getName().equals(hotel.getName())) return false;
        return getCity().equals(hotel.getCity());
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getCity().hashCode();
        return result;
    }
}
