package com.research.database.socialnetwork.storage.mysql.repo;

import com.research.database.socialnetwork.storage.mysql.entity.Friend;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface FriendRepository extends CrudRepository<Friend, Integer> {

    List<Friend> findByInviter(Integer inviterId);

    @Query("select f from Friend f where (f.inviter=:userId and f.trangthai=:trangthai) or (f.receiver=:userId and f.trangthai=:trangthai)")
    public List<Friend> findByUid(@Param("userId") Integer userId, @Param("trangthai") int trangthai);

    @Query("select f from Friend f where (f.receiver=:receiver and f.trangthai=:trangthai)")
    public List<Friend> findWaitings(@Param("receiver") Integer receiver, @Param("trangthai") int trangthai);

    @Query("select f from Friend f where (f.inviter=:inviter and f.trangthai=:trangthai)")
    public List<Friend> findRespondings(@Param("inviter") Integer inviter, @Param("trangthai") int trangthai);

    @Query("select f from Friend f where (f.inviter=:user1 and f.receiver=:user2) or (f.inviter=:user2 and f.receiver=:user1)")
    public Collection<Friend> findByKey(@Param("user1") int user1, @Param("user2") int user2);

}

