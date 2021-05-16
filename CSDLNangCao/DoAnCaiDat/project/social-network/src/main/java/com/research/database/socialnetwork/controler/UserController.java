package com.research.database.socialnetwork.controler;

import com.research.database.socialnetwork._enum.FriendStatus;
import com.research.database.socialnetwork.storage.es.service.ESUserService;
import com.research.database.socialnetwork.storage.mysql.entity.Friend;
import com.research.database.socialnetwork.storage.mysql.entity.User;
import com.research.database.socialnetwork.storage.mysql.service.IFriendService;
import com.research.database.socialnetwork.storage.mysql.service.IUserService;
import com.research.database.socialnetwork.utils.CommonConfig;
import com.research.database.socialnetwork.view.LayoutView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private IUserService userService;
    @Autowired
    private IFriendService friendService;

    @Autowired
    private ESUserService esUserService;

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
        Friend friend = friendService.getItem(CommonConfig.MY_ID, id);
        List<Integer> allFriendIds = friendService.getAllFriendIds(id, FriendStatus.ACCEPTED.getValue());
        if (allFriendIds != null && !allFriendIds.isEmpty()) {
            List<Friend> friends = userService.getByIds(allFriendIds);
            LayoutView.renderFriends(friends);
        }
        return _returnUser(user, model, friend);
    }

    @PostMapping("/profile/addfriend")
    public String addFriend(@RequestParam Map<String, String> body, Model model) {
        Integer id = Integer.valueOf(body.get("id"));
        Optional<User> userOpt = userService.getById(id);
        User user = userOpt.get();
        if (id == CommonConfig.MY_ID) {
            return _returnUser(user, model, null);
        }
        Friend friend = friendService.addMyFriend(user.getUserId(), CommonConfig.MY_ID);
        return "redirect:/profile/" + user.getUserId();
    }

    private String _returnUser(User user, Model model, Friend friend) {
        LayoutView.renderLayout(model);
        LayoutView.renderUser(user, model);
        LayoutView.renderFriend(friend, model);
        return "profile";
    }
}
