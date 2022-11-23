package com.example.ticketnow.service;

import com.example.ticketnow.bo.UserBO;
import com.example.ticketnow.model.ValidationMessage;

public interface UserService {

    ValidationMessage validateUser(UserBO userBO);


}
