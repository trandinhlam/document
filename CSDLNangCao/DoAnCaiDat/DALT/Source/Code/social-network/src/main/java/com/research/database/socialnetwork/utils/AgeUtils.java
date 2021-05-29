package com.research.database.socialnetwork.utils;

import java.util.concurrent.TimeUnit;

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

    public static int calculateAgeFromBirthday(int birthday) {
        int now = (int) (System.currentTimeMillis() / 1000l);
        return (now - birthday) / (int) TimeUnit.DAYS.toSeconds(365);
    }

    public static String calculateGenerationFromBirthday(int birthday) {
        return getGeneration(calculateAgeFromBirthday(birthday));
    }
}
