package com.research.database.socialnetwork.storage.es.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ESSearchUserDTO {
    private Integer userId;
    private String name;
    private int gender;
    private String avatar;
    private boolean isRequested = false;
    private Integer friendRequestedStatus;
}
