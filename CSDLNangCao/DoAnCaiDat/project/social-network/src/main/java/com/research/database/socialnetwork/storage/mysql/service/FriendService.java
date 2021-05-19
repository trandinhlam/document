package com.research.database.socialnetwork.storage.mysql.service;

import com.research.database.socialnetwork._enum.FriendStatus;
import com.research.database.socialnetwork.storage.mysql.entity.Friend;
import com.research.database.socialnetwork.storage.mysql.repo.FriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class FriendService implements IFriendService<Friend> {

    @Autowired
    FriendRepository repo;

    @Override
    public List<Friend> getAll() {
        return (List<Friend>) repo.findAll();
    }

    @Override
    public List<Integer> getAllFriendIds(int userId, int trangthai) {
        List<Friend> friends = repo.findByUid(userId, trangthai);
        if (friends == null) {
            return Collections.EMPTY_LIST;
        }
        Set<Integer> rs = new HashSet<>();
        for (Friend f : friends) {
            if (f.getReceiver() != userId) {
                rs.add(f.getReceiver());
            } else if (f.getInviter() != userId) {
                rs.add(f.getInviter());
            }
        }
        return rs.stream().collect(Collectors.toList());
    }

    @Override
    public Friend getItem(Integer userYC, int userNhan) {
        Collection<Friend> fr = repo.findByKey(userYC, userNhan);
        return fr != null && !fr.isEmpty() ? fr.stream().findFirst().get() : null;
    }

    @Override
    public Friend save(Friend friend) {
        return repo.save(friend);
    }

    @Override
    public Friend addMyFriend(Integer userId, int myId) {
        Friend fr = getItem(myId, userId);
        if (fr == null) {
            fr = new Friend();
            fr.setInviter(myId);
            fr.setReceiver(userId);
            fr.setNgayketban(new Timestamp(System.currentTimeMillis()));
            fr.setTrangthai(FriendStatus.REQUESTING.getValue());
        } else if (fr.getTrangthai() == FriendStatus.REQUESTING.getValue()) {
            fr.setTrangthai(FriendStatus.ACCEPTED.getValue());
        }
        return save(fr);
    }

    @Override
    public List<Integer> getAllWaitingIds(Integer receiver) {
        List<Friend> friends = repo.findWaitings(receiver, FriendStatus.REQUESTING.getValue());
        if (friends == null) {
            return Collections.EMPTY_LIST;
        }
        return friends.stream().map(f -> f.getInviter()).collect(Collectors.toList());
    }
}
