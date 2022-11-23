package com.example.ticketnow.model;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.sql.Time;
import java.sql.Timestamp;

@Data
@Document(value = "comments")
public class Comments {

    @Id
    private String id;
    private String comment;
    private String idOfTheUserWhoCommentedIt;
    private String nameOfTheUserWhoCommented;

    private Timestamp commentedAt;


}
