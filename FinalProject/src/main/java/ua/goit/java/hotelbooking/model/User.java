package ua.goit.java.hotelbooking.model;

public class User {
    private Long id;
    private String fio;

    public User(Long id, String fio) {
        this.id = id;
        this.fio = fio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }
}
