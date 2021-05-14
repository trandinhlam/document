package com.research.database.socialnetwork;

import com.research.database.socialnetwork.storage.mysql.entity.User;
import com.research.database.socialnetwork.storage.mysql.service.IUserService;
import com.research.database.socialnetwork.utils.AvatarUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/profile/{id}")
    public String getProfile(@PathVariable Integer id) {
        Optional<User> user = userService.getById(id);
        if (user.isPresent()) {
            System.out.println(user.get());
        }
        return "profile";
    }
}
