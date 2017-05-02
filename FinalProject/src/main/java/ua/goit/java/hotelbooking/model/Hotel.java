package ua.goit.java.hotelbooking.model;

import java.util.List;

public class Hotel {
    private Long id;
    private String name;
    private String city;
    private List<Room> rooms;

    public Hotel(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public Hotel(Long id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public Hotel(String name, String city, List<Room> rooms) {
        this.name = name;
        this.city = city;
        this.rooms = rooms;
    }

    public Hotel(Long id, String name, String city, List<Room> rooms) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.rooms = rooms;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
