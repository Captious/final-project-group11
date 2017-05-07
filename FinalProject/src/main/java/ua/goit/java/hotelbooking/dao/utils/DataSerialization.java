package ua.goit.java.hotelbooking.dao.utils;

import java.io.*;

public class DataSerialization {
    private DataSerialization(){}

    public static Object deserializeData(String filePath){
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))){
            return in.readObject();
            //TODO: Please, use multiple catching for all exceptions.
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void serializeData(String filePath, Object obj){
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))){
            out.writeObject(obj);
            //TODO: Please, use multiple catching for all exceptions.
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            //TODO: Please, use multiple catching.
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
