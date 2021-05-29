package com.research.database.socialnetwork.view;

import com.research.database.socialnetwork.storage.mysql.entity.Friend;
import com.research.database.socialnetwork.storage.mysql.entity.User;
import org.springframework.ui.Model;

import java.util.List;
import java.util.stream.Collectors;

public class LayoutView {


    public static void renderLayout(int myId, Model model) {
        model.addAttribute("myId", myId);
        model.addAttribute("host", "http://localhost:8080/");
    }

    public static void renderUser(int myId, User user, Friend friend, Model model) {
        model.addAttribute("user", new UserViewEntity(myId, user, friend));
    }

    public static void renderFriends(int myId, List<User> friends, Model model) {
        List<UserViewEntity> userView = friends.stream().map(u -> new UserViewEntity(myId, u, null)).collect(Collectors.toList());
        model.addAttribute("friends", userView);
    }

    public static void renderWaitings(int myId, List<User> waitings, Model model) {
        List<UserViewEntity> userView = waitings.stream().map(u -> new UserViewEntity(myId, u, null)).collect(Collectors.toList());
        model.addAttribute("waitings", userView);
    }
}
