package ua.goit.java.hotelbooking.model;

import java.util.ArrayList;
import java.util.List;

public class Hotel extends BaseModel {
    private static final long serialVersionUID = 550151019702604957L;
    private String name;
    private String city;
    private List<Room> rooms;

    public Hotel(String name, String city) {
        this.name = name;
        this.city = city;
        this.rooms = new ArrayList<>();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hotel hotel = (Hotel) o;

        if (!getName().toLowerCase().equals(hotel.getName().toLowerCase())) return false;
        return getCity().toLowerCase().equals(hotel.getCity().toLowerCase());
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getCity().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return String.format("hotel: %-13s city: %-13s rooms amount: %d", getName(), getCity(), getRooms().size());
    }
}
