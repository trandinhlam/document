package com.research.database.socialnetwork.storage.mysql.service;

import com.research.database.socialnetwork.storage.mysql.entity.User;

import java.util.Optional;

public interface IUserService<T extends User> {

    Optional<T> getById(Integer id);

    T save(T user);

    public void generateInit();

    int addMyFriend(int userid, int myid);
}
