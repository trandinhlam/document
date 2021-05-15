package com.research.database.socialnetwork.storage.mysql.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "banbe")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Friend {

    @Column(name = "useryc")
    private Integer inviter;

    @Column(name = "usernhan")
    private String name;

    @Column(name = "ngayketban")
    private Timestamp gender;

    @Column(name = "trangthai")
    private int trangthai;
}
