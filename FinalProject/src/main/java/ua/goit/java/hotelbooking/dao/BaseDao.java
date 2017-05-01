package ua.goit.java.hotelbooking.dao;

import java.util.List;

public interface BaseDao<T> {
    T persist(T element);
    boolean remove(T element);
    List<T> getAll();
}
