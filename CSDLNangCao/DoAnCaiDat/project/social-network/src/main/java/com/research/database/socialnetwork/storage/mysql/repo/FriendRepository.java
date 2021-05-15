package com.research.database.socialnetwork.storage.mysql.repo;

import com.research.database.socialnetwork.storage.mysql.entity.Friend;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendRepository extends CrudRepository<Friend, Integer> {


}

