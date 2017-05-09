package ua.goit.java.hotelbooking.services;

import java.util.List;

public interface ManageService<T> {
    void add(T element);
    T edit(T element);
    List<T> getAll();
}
