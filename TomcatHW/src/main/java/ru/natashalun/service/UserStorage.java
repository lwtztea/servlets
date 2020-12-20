package ru.natashalun.service;

import java.util.HashMap;
import java.util.Map;

public class UserStorage {

    private static Map<String, String> users = new HashMap<String, String>();

    public static boolean isUserExist(String username) {
        return users.containsKey(username);
    }

    public static boolean isPasswordCorrect(String username, String password) {
        return users.get(username).equals(password);
    }

    public static void add(String username, String password) {
        users.put(username, password);
    }
}
