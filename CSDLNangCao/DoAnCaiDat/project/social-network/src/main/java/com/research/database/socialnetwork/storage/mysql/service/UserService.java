package com.research.database.socialnetwork.storage.mysql.service;

import com.research.database.socialnetwork.storage.mysql.entity.User;
import com.research.database.socialnetwork.storage.mysql.entity.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository repo;

    @Override
    public List<User> getAll() {
        return (List<User>) repo.findAll();
    }
}
