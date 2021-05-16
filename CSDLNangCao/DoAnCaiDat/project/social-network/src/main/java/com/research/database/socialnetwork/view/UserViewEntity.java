package com.research.database.socialnetwork.view;

import com.research.database.socialnetwork.storage.mysql.entity.Friend;
import com.research.database.socialnetwork.storage.mysql.entity.User;
import com.research.database.socialnetwork.utils.CommonConfig;
import com.research.database.socialnetwork.utils.TimeUtils;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.TimeUnit;

@Getter
@Setter
public class UserViewEntity {
    public boolean isMy;
    public int userId;
    public String name;
    public String avatar;
    public String birthdate;
    public int age;
    public String gender;
    public int friendStatus=-1;

    public UserViewEntity(int myId,User user, Friend friend) {
        this.isMy = user.getUserId() == myId;
        this.userId = user.getUserId();
        this.name = user.getName();
        this.avatar = user.getAvatar();
        this.birthdate = TimeUtils.format(user.getBirth() * 1000l);
        int now = (int) (System.currentTimeMillis() / 1000l);
        int age = (now - user.getBirth()) / (int) TimeUnit.DAYS.toSeconds(365);
        this.age = age;
        this.gender = user.getGender() == 1 ? "Nam" : "Nữ";
        if (friend != null) {
            friendStatus = friend.getTrangthai();
        }
    }
}
