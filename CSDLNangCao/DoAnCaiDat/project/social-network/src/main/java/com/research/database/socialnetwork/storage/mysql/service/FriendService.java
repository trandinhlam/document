package com.research.database.socialnetwork.storage.mysql.service;

import com.research.database.socialnetwork.storage.mysql.entity.Friend;
import com.research.database.socialnetwork.storage.mysql.repo.FriendRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FriendService implements IFriendService<Friend> {


    @Autowired
    FriendRepository repo;

    @Override
    public List<Friend> get(Integer userId, int trangthai) {
        return null;
    }

    @Override
    public Friend save(Friend friend) {
        return repo.save(friend);
    }
}
