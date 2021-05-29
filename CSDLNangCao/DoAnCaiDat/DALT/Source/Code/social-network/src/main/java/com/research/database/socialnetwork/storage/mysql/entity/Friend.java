package com.research.database.socialnetwork.storage.mysql.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "banbe")
@IdClass(FriendPK.class)
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
    private Timestamp ngayketban;

    @Column(name = "trangthai")
    private int trangthai;

}
