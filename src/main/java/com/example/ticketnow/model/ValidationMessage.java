package com.example.ticketnow.model;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class ValidationMessage {


    private boolean usernameAndPasswordMatches;
    private boolean isPasswordValid;
    private boolean isUserIdValid;
    private String username;
    private String userId;


    public ValidationMessage(boolean usernameAndPasswordMatches) {
        this.usernameAndPasswordMatches = usernameAndPasswordMatches;
    }





}
