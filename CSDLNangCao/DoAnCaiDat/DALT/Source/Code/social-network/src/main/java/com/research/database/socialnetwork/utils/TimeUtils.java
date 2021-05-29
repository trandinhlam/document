package com.research.database.socialnetwork.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {
    static String pattern = "yyyy-MM-dd";
    static SimpleDateFormat sdf = new SimpleDateFormat(pattern);

    public static String format(long timestamp) {
        return sdf.format(new Date(timestamp));
    }

}
