package com.may.utils;

/**
 * Hold the reference to the current user.
 *
 * Created by Eugene on 19-Jun-16.
 */
public class UserUtils {
    private static final ThreadLocal<String> currentUser = new ThreadLocal<String>();

    public static String getCurrentUser() {
        return currentUser.get();
    }

    public static void setCurrentUser(String username) {
        currentUser.set(username);
    }
}
