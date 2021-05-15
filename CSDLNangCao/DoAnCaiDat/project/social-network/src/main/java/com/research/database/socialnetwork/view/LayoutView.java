package com.research.database.socialnetwork.view;

import com.research.database.socialnetwork.storage.mysql.entity.User;
import com.research.database.socialnetwork.utils.TimeUtils;
import org.springframework.ui.Model;

import java.util.concurrent.TimeUnit;

public class LayoutView {

    public static void setUser(User user, Model model) {
        renderLayout(model);

        model.addAttribute("user", user);
        String date = TimeUtils.format(user.getBirth() * 1000l);
        model.addAttribute("user_birthdate", date);
        int now = (int) (System.currentTimeMillis() / 1000l);
        int age = (now - user.getBirth()) / (int) TimeUnit.DAYS.toSeconds(365);
        model.addAttribute("user_age", age);
        model.addAttribute("user_gender", user.getGender() == 1 ? "Nam" : "Nữ");
    }

    private static void renderLayout(Model model) {
        model.addAttribute("host", "http://localhost:8080/");
    }
}
