package com.research.database.socialnetwork.storage.mysql.entity;

import java.util.Arrays;

public enum FriendRequesStatus {
    WAITING_APPROVE(1, "Waiting for approve"),
    ACCEPTED(2, "Accepted");

    private int code;
    private String status;

    FriendRequesStatus(int code, String status) {
        this.status = status;
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public FriendRequesStatus getStatusByCode(int code) {
        for (FriendRequesStatus item : values()) {
            if (item.getCode() == code) {
                return item;
            }
        }
        return null;
    }
}
