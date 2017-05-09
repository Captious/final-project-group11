package ua.goit.java.hotelbooking.dao.impl;

import ua.goit.java.hotelbooking.dao.BaseDao;
import ua.goit.java.hotelbooking.dao.utils.DataSerialization;
import ua.goit.java.hotelbooking.model.BaseModel;
import ua.goit.java.hotelbooking.model.User;

import java.util.List;
import java.util.stream.IntStream;

public abstract class BaseDaoImpl<T extends BaseModel> extends IdCollectionHolder implements BaseDao<T> {
    @Override
    public T persist(T element) {
        List<T> entityList = getAll();
        if (element.getId() == null) {
            increaseLastId();
            element.setId(getLastId());
            entityList.add(element);
        } else {
            try {
                int index = IntStream.range(0, entityList.size())
                        .filter(i -> element.getId().equals(entityList.get(i).getId()))
                        .findFirst()
                        .getAsInt();
                entityList.set(index, element);
            } catch (RuntimeException exception) {
                throw new RuntimeException(String.format("There is no element with that ID (%d) in the database %s",
                        element.getId(), getEntityName()));
            }
        }
        DataSerialization.serializeData(getFilePath(), entityList);
        return element;
    }

    @Override
    public boolean remove(T element) {
        List<T> entityList = getAll();
        Long id = element.getId();
        if (id == null) {
            throw new RuntimeException(String.format("There is no such %s in database", getEntityName()));
        }
        if ((entityList.removeIf(x -> x.getId().equals(id)))) {
            DataSerialization.serializeData(getFilePath(), entityList);
            return true;
        }
        return false;
    }

    protected void increaseLastId() {
        Long lastId = getLastId() + 1;
        getLastIdCollection().put(getEntityName(), lastId);
        setLastIdCollection(getLastIdCollection());
    }

    protected abstract Long getLastId();

    protected abstract String getEntityName();

    protected abstract String getFilePath();
}
