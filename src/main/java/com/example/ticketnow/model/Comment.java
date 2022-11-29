package com.example.ticketnow.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Document(value = "comments")
public class Comment {

    @Id
    private String id;
    private String comment;

    private String ticketId;
    private Date commentedAt;

}
