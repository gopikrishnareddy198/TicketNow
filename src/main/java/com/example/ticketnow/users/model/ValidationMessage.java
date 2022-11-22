package com.example.ticketnow.users.model;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class ValidationMessage {


    private boolean usernameAndPasswordMatches;
    private boolean isPasswordValid;
    private boolean isUserIdValid;

    public ValidationMessage(boolean usernameAndPasswordMatches) {
        this.usernameAndPasswordMatches = usernameAndPasswordMatches;
    }





}
