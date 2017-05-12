package ua.goit.java.hotelbooking.dao.impl;

import ua.goit.java.hotelbooking.dao.RoomDao;
import ua.goit.java.hotelbooking.dao.utils.DataSerialization;
import ua.goit.java.hotelbooking.model.Room;

import java.util.ArrayList;
import java.util.List;

public class RoomDaoImpl extends BaseDaoImpl<Room> implements RoomDao {

    private static final String FILE_PATH =
            String.format("%s/src/main/java/ua/goit/java/hotelbooking/data/room.txt",
            System.getProperty("user.dir"));
    private static final String ENTITY = "Room";

    private RoomDaoImpl() {
        super(ENTITY);
    }

    private static class RoomHolder {
        private final static RoomDaoImpl INSTANCE = new RoomDaoImpl();
    }

    public static RoomDaoImpl getInstance() {
        return  RoomHolder.INSTANCE;
    }

    @Override
    protected String getEntityName() {
        return ENTITY;
    }

    @Override
    protected String getFilePath() {
        return FILE_PATH;
    }

    @Override
    public List<Room> getAll() {
        return (ArrayList<Room>) DataSerialization.deserializeData(FILE_PATH);
    }

    @Override
    public Room getByHotel(String roomNumber, Long hotelId) {
        List<Room> answer = new ArrayList<>();
        getAll().forEach(room -> {if (room.getHotel().getId().equals(hotelId)
                &&room.getNumber().equals(roomNumber)) answer.add(room); });
        return answer.size() == 0 ? null : answer.get(0);
    }
}
