package com.example.ticketnow.users.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document("users")
@Data
public class User {

    @Id
    private String userId;
    private String username;
    private String password;
    private Set<String> roles;

}
