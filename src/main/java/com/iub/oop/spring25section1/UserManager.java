package com.iub.oop.spring25section1;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
    public static List<User> userList = new ArrayList<>();

    static {
        userList.add(new User("asif", "1234", 50));
        userList.add(new User("test", "1234", 20));
        userList.add(new User("admin", "1234", 30));
        userList.add(new User("cis101", "cis101", 100));
    }
}
