package com.research.database.socialnetwork._enum;

import lombok.Getter;

@Getter
public enum FriendStatus {
    REQUESTING(0),
    ACCEPTED(1),
    REJECTED(2);

    private final int value;

    FriendStatus(int value) {
        this.value = value;
    }
}
