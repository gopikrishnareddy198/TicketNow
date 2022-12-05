package com.example.ticketnow.service;

import com.example.ticketnow.bo.UserBO;
import com.example.ticketnow.model.User;
import com.example.ticketnow.model.ValidationMessage;

public interface UserService {

    ValidationMessage validateUser(UserBO userBO);

    boolean checkIfTheUserIsPresent(String userid);


    User createUserAndCategory(UserBO userBO, String category);

    boolean deleteUserUsingId(String userid);
}
