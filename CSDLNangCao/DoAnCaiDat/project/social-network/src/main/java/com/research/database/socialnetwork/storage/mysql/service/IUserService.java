package com.research.database.socialnetwork.storage.mysql.service;

import com.research.database.socialnetwork.storage.mysql.entity.User;

import java.util.List;

public interface IUserService {
    List<User> getAll();
}
