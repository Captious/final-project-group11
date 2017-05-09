package ua.goit.java.hotelbooking.model;

public class Room extends BaseModel {
    private static final long serialVersionUID = -1468192959002520694L;
    private String number;
    private Hotel hotel;

    public Room(String roomNumber) {
        this.number = roomNumber;
    }

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        if (!getNumber().toLowerCase().equals(room.getNumber().toLowerCase())) return false;
        return getHotel().equals(room.getHotel());
    }

    @Override
    public int hashCode() {
        int result = getNumber().hashCode();
        result = 31 * result + getHotel().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return String.format("room number: %-10s  hotel: %s", getNumber(), getHotel().getName());
    }
}
