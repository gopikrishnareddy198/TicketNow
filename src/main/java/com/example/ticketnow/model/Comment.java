package com.example.ticketnow.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(value = "comments")
public class Comment {

    @Id
    private String id;
    private String comment;
    private String nameOfTheUserWhoCommented;
    private String idOfTheUserWhoCommentedIt;

    private LocalDateTime commentedAt;

}
