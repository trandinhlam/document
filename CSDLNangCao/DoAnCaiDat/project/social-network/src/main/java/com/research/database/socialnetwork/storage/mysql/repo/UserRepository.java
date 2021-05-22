package com.research.database.socialnetwork.storage.mysql.repo;

import com.research.database.socialnetwork.storage.mysql.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findById(Integer id);
}
