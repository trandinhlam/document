package com.research.database.socialnetwork.utils;

public class AgeUtils {

    public static final String getGeneration(int age) {
        if (age < 21) {
            return "z";
        }
        if (age < 31) {
            return "y";
        }
        return "x";
    }
}
