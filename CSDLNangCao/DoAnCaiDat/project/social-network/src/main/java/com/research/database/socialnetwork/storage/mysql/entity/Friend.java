package com.research.database.socialnetwork.storage.mysql.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "banbe")
@IdClass(Friend.FriendId.class)
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Friend {

    @Id
    @Column(name = "useryc")
    private Integer inviter;

    @Id
    @Column(name = "usernhan")
    private Integer receiver;

    @Column(name = "ngayketban")
    private Timestamp gender;

    @Column(name = "trangthai")
    private int trangthai;

    @Embeddable
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public class FriendId implements Serializable {
        private Integer inviter;
        private Integer receiver;
    }
}
