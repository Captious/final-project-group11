package ua.goit.java.hotelbooking.model;

public class User extends BaseModel {
    private static final long serialVersionUID = 68369264134601000L;
    private String fio;

    public User(String fio) {
        this.fio = fio;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return getFio().toLowerCase().equals(user.getFio().toLowerCase());
    }

    @Override
    public int hashCode() {
        return getFio().hashCode();
    }

    @Override
    public String toString() {
        return String.format("fio: %s", getFio());
    }
}
