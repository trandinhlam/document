package com.research.database.socialnetwork.view;

import com.research.database.socialnetwork.storage.mysql.entity.Friend;
import com.research.database.socialnetwork.storage.mysql.entity.User;
import com.research.database.socialnetwork.utils.CommonConfig;
import com.research.database.socialnetwork.utils.TimeUtils;
import org.springframework.ui.Model;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LayoutView {


    public static void renderLayout(Model model) {
        model.addAttribute("host", "http://localhost:8080/");
    }

    public static void renderUser(User user, Model model) {
        model.addAttribute("user_my", user.getUserId() == CommonConfig.MY_ID);
        model.addAttribute("user", user);
        String date = TimeUtils.format(user.getBirth() * 1000l);
        model.addAttribute("user_birthdate", date);
        int now = (int) (System.currentTimeMillis() / 1000l);
        int age = (now - user.getBirth()) / (int) TimeUnit.DAYS.toSeconds(365);
        model.addAttribute("user_age", age);
        model.addAttribute("user_gender", user.getGender() == 1 ? "Nam" : "Nữ");
    }

    public static void renderFriend(Friend friend, Model model) {
        if (friend == null) {
            model.addAttribute("friend_not", true);
        } else {
            model.addAttribute("friend_has", true);
            model.addAttribute("friend_status", friend.getTrangthai());
        }
    }

    public static void renderFriends(List<Friend> friends) {
        
    }
}
