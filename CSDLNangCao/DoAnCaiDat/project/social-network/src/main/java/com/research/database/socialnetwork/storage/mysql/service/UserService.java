package com.research.database.socialnetwork.storage.mysql.service;

import com.research.database.socialnetwork.storage.mysql.entity.User;
import com.research.database.socialnetwork.storage.mysql.repo.UserRepository;
import com.research.database.socialnetwork.utils.AvatarUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository repo;

    @Override
    public List<User> getAll() {
        return (List<User>) repo.findAll();
    }

    @Override
    public Optional<User> getById(Integer id) {
        return repo.findById(id);
    }

    @Override
    public User save(User user) {
        return repo.save(user);
    }

    public void generateInit() {
        for (int i = 105; i < 308; i++) {
            Optional<User> user = this.getById(i);
            if (user.isPresent()) {
                User u = user.get();
                u.setAvatar(AvatarUtils.random(u.getGender()));
                this.save(u);
            }
        }
    }

    @Override
    public int addMyFriend(int userid, int myid) {
        return 0;
    }
}
