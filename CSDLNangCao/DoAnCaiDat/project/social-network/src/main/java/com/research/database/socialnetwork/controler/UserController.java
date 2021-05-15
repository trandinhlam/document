package com.research.database.socialnetwork.controler;

import com.research.database.socialnetwork.storage.mysql.entity.User;
import com.research.database.socialnetwork.storage.mysql.service.IUserService;
import com.research.database.socialnetwork.utils.AvatarUtils;
import com.research.database.socialnetwork.utils.CommonConfig;
import com.research.database.socialnetwork.utils.TimeUtils;
import com.research.database.socialnetwork.view.LayoutView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/")
    public String index(Model model) {
        return "home";
    }

    @GetMapping("/profile/{id}")
    public String getProfile(@PathVariable Integer id, Model model) {
        Optional<User> userOpt = userService.getById(id);
        if (userOpt.isPresent()) {
            System.out.println(userOpt.get());
        }
        User user = userOpt.get();
        //view
        return _returnUser(user, model);
    }

    @PostMapping("/profile/addfriend/{id}")
    public String addFriend(@PathVariable Integer id, Model model) {
        Optional<User> userOpt = userService.getById(id);
        User user = userOpt.get();
        int rs = userService.addMyFriend(user.getUserId(), CommonConfig.MY_ID);
        model.addAttribute("rs", rs);
        return _returnUser(user, model);
    }

    private String _returnUser(User user, Model model) {
        LayoutView.setUser(user, model);
        return "profile2";
    }
}
