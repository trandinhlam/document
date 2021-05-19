package com.research.database.socialnetwork.utils;

import com.research.database.socialnetwork.storage.mysql.entity.Friend;
import com.research.database.socialnetwork.storage.mysql.entity.User;
import com.research.database.socialnetwork.storage.mysql.service.IFriendService;
import com.research.database.socialnetwork.storage.mysql.service.IUserService;
import com.research.database.socialnetwork.storage.neo4j.Neo4jService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
public class DataUtils {

    @Autowired
    private IUserService userService;
    @Autowired
    private IFriendService friendService;

    @Autowired
    private Neo4jService neo4jService;


    public void initrandom() {
        List<User> users = userService.getAll();
        List<Integer> userIds = users.stream().map(u -> u.getUserId()).collect(Collectors.toList());
        //random 1 user với 1 user khac
        for (int userId : userIds) {
            for (int i = 0; i < 5; i++) {
                int rand = new Random().nextInt(userIds.size());
                Integer nexFriend = userIds.get(rand);
                if (nexFriend == userId) {
                    continue;
                }
                friendService.addMyFriend(userId, nexFriend);
            }
        }
    }

    public void putFriendIntoGraph() {
        List<Friend> friends = friendService.getAll();
        for (Friend f : friends) {
            neo4jService.insertFriend(f.getInviter(), f.getReceiver());
        }
    }

    public void putAgeIntoGraph() {
        List<User> users = userService.getAll();
        users.forEach(u -> {
            int now = (int) (System.currentTimeMillis() / 1000l);
            int age = (now - u.getBirth()) / (int) TimeUnit.DAYS.toSeconds(365);
            String generation = AgeUtils.getGeneration(age);
            neo4jService.insertGen(u.getUserId(), generation);
        });
    }

    public void putGenderIntoGraph() {
        List<User> users = userService.getAll();
        users.forEach(u -> {
            if (u.getCity() != null && !u.getCity().isEmpty()) {
                neo4jService.insertAddress(u.getUserId(), u.getCity().toLowerCase());
            }
        });
    }

    public void putAddressIntoGraph() {

    }
}
