package com.research.database.socialnetwork;

import com.research.database.socialnetwork.storage.mysql.entity.User;
import com.research.database.socialnetwork.storage.mysql.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/")
    public String index(Model model) {
        List<User> users = userService.getAll();
        System.err.println(users);
        return "index";
    }

    @GetMapping("/profile")
    public String getProfile(Model model) {
        return "profile";
    }
}
