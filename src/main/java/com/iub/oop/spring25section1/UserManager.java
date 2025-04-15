package com.iub.oop.spring25section1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserManager {
    public static List<User> userList = new ArrayList<>();
    private static final String filename = "user.bin";

    static {
//        userList.add(new User("asif", "1234", 50));
//        userList.add(new User("test", "1234", 20));
//        userList.add(new User("admin", "1234", 30));
//        userList.add(new User("cis101", "cis101", 100));
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename));) {
            UserManager.userList = (List< User >) inputStream.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveToFile() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            outputStream.writeObject(userList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
