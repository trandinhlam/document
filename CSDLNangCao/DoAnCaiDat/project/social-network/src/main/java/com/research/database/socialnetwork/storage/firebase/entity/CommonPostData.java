package com.research.database.socialnetwork.storage.firebase.entity;

import com.google.cloud.firestore.annotation.ServerTimestamp;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommonPostData {
    @ServerTimestamp
    private Date dateUpdated;
    private Integer userId;
    private String userName;
}
