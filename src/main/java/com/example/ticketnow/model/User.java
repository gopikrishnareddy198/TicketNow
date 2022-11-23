package com.example.ticketnow.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Set;

@Document("users")
@Data
public class User {

    @Id
    @Field(value = "_id")
    private String userId;
    private String username;
    private String password;


    private Set<String> roles;

}
