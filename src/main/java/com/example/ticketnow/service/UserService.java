package com.example.ticketnow.service;

import com.example.ticketnow.users.bo.UserBO;
import com.example.ticketnow.users.model.ValidationMessage;

public interface UserService {

    ValidationMessage validateUser(UserBO userBO);
}
