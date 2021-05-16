package com.research.database.socialnetwork.storage.mysql.service;

import com.research.database.socialnetwork.storage.mysql.entity.Friend;

import java.util.List;

public interface IFriendService<T extends Friend> {

    public List<Integer> getAllFriendIds(int userId, int trangthai);

    T getItem(Integer userYC, int userNhan);

    T save(T friend);

    T addMyFriend(Integer userId, int myId);

    List<Integer> getAllWaitingIds(Integer receiver);
}
