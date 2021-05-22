package com.research.database.socialnetwork.storage.firebase.dto;

import com.research.database.socialnetwork.storage.firebase.entity.Owner;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {
    private String content;
}
