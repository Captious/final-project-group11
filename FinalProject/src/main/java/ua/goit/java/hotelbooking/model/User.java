package ua.goit.java.hotelbooking.model;

public class User extends BaseModel {
    private static final long serialVersionUID = 68369264134601000L;
    private String fio;
    private String login;

    public User(String fio, String login) {
        this.fio = fio;
        this.login = login;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return getLogin().toLowerCase().equals(user.getLogin().toLowerCase());
    }

    @Override
    public int hashCode() {
        return getLogin().hashCode();
    }

    @Override
    public String toString() {
        return String.format("fio: %s\nlogin: %s", getFio(),getLogin());
    }
}
