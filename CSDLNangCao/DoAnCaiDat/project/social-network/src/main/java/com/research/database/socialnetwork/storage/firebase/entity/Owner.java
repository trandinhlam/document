package com.research.database.socialnetwork.storage.firebase.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Owner implements Serializable {
    private int userId;
    private String name;
}
