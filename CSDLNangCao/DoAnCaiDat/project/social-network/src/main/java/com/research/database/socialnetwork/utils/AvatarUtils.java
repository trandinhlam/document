package com.research.database.socialnetwork.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class AvatarUtils {
    public static final List<String> randomAvatarMale = Arrays.asList(
            "https://pickaface.net/gallery/avatar/unr_random_180527_1151_2bcb7h9.png",
            "https://pickaface.net/gallery/avatar/unr_random_160817_0304_2mvqp69.png",
            "https://pickaface.net/gallery/avatar/unr_randomguy_190409_1742_4g5.png",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTlBA1VIHzwKpA_QJe5NlVT7Uginkr2o4y-ollqjdo7x_09KSHmGKRk7SdyrTM3yOw23Zc&usqp=CAU",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSJSutXL6hbRKjv5HdXviqugjWSb2aOc5hQX1qaiCe_SQUvqxN7K95kSFP_szSMoRosegg&usqp=CAU",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS9vBUGfCHgyruAr17JbBq5ZCbEVd5MoycfKwj-JzQuRzgD4IhhuCdz3HPmQVYRO3yZjY4&usqp=CAU"
    );
    public static final List<String> randomAvatarFemale = Arrays.asList(
            "https://cdn1.iconfinder.com/data/icons/avatars-1-5/136/84-512.png",
            "https://cdn1.iconfinder.com/data/icons/avatars-1-5/136/78-512.png",
            "https://static.vecteezy.com/system/resources/previews/002/002/257/non_2x/beautiful-woman-avatar-character-icon-free-vector.jpg",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSl3cWy0U8i1ls1gEzcMPkxlusSyFf4m7FEwYtwOzUOqdg0rH8hqPauCt37n_mYpsxJvfE&usqp=CAU",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTzt6hlYHrHxha4qKkylzE5bCSVj9d-ZdDdGecERj4R_nrsDpFKgVkTBbzs9YAXc_uBOhQ&usqp=CAU",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTnx9HYer1wTC_vVCCLyIWCpHdjXaOJsr5EEIACQjrK__lhRK8XgK3mDViybo6yrdzrmzM&usqp=CAU"
    );

    public static String random(int gender) {
        if (gender == 1) {
            int index = new Random().nextInt(randomAvatarMale.size());
            return randomAvatarMale.get(index);
        }
        int index = new Random().nextInt(randomAvatarFemale.size());
        return randomAvatarFemale.get(index);
    }

}
