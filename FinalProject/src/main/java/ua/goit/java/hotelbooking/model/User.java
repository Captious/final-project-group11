package ua.goit.java.hotelbooking.model;

import java.io.Serializable;

public class User implements Serializable, IdManager{
    private Long id;
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

        User user = (User) o;

        return getFio().equals(user.getFio());
    }

    @Override
    public int hashCode() {
        return getFio().hashCode();
    }
}
