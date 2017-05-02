package ua.goit.java.hotelbooking.model;

import java.io.Serializable;

public class User implements Serializable{
    private Long id;
    private String fio;

    public User(String fio) {
        this.fio = fio;
    }

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
