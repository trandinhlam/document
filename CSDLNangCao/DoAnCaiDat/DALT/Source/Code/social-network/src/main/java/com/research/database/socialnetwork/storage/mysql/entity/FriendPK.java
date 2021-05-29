package com.research.database.socialnetwork.storage.mysql.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class FriendPK implements Serializable {
    private Integer inviter;
    private Integer receiver;

    public FriendPK(Integer inviter) {
        this.inviter = inviter;
    }

    public FriendPK() {
    }

    public FriendPK(Integer inviter, Integer receiver) {
        this.inviter = inviter;
        this.receiver = receiver;
    }
}
