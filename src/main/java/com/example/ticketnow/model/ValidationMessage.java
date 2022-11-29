package com.example.ticketnow.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;


@Data
@NoArgsConstructor
public class ValidationMessage {


    private boolean usernameAndPasswordMatches;
    private boolean isPasswordValid;
    private boolean isUserIdValid;
    private String username;
    private String userId;
    private Set<String> roles;


    public ValidationMessage(boolean usernameAndPasswordMatches) {
        this.usernameAndPasswordMatches = usernameAndPasswordMatches;
    }





}
