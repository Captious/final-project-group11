package ua.goit.java.hotelbooking.services;

public interface ManageService<T> {
    void add(T element);
    T edit(T element);
}
