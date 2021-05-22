package com.research.database.socialnetwork.utils;

public class CommonConfig {
    public static Integer MY_ID = 105;
    public static Integer updatePrincipal(Integer userId){
        MY_ID = userId;
        return MY_ID;
    }
}
