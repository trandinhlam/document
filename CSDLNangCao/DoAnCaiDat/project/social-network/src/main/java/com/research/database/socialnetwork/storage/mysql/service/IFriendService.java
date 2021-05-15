package com.research.database.socialnetwork.storage.mysql.service;

import com.research.database.socialnetwork.storage.mysql.entity.Friend;

import java.util.List;

public interface IFriendService<T extends Friend> {

    List<T> get(Integer id, int trangthai);

    T save(T friend);

}
