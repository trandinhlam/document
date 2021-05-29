package com.research.database.socialnetwork.storage.es.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "user_index")
public class ESUser {
    @Id
    private Integer userId;

    @Field(name = "ten", type = FieldType.Text)
    private String name;

    @Field(name = "gioitinh")
    private int gender;

    @Field(name = "avatar", type = FieldType.Text)
    private String avatar;
}
