package com.example.ticketnow.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(value="Category")
public class Category {

    @Id
    private String id;

    private String userId;
    private String username;
    private String category;



}



