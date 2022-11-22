package com.example.ticketnow.service;

import com.example.ticketnow.repo.UserRepository;
import com.example.ticketnow.users.bo.UserBO;
import com.example.ticketnow.users.model.User;
import com.example.ticketnow.users.model.ValidationMessage;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public ValidationMessage validateUser(UserBO userBO) {
        Optional<User> optionalUser;
        User user;
        UserBO recordInDatabase;
        ValidationMessage validationMessage;

        optionalUser = userRepository.findById(userBO.getUserId());

        if (optionalUser.isPresent()) {
            user = optionalUser.get();
            recordInDatabase = new UserBO();

            BeanUtils.copyProperties(user, recordInDatabase);

            if(recordInDatabase.getPassword()!=null)
                recordInDatabase.setPassword(Base64.getDecoder().decode(recordInDatabase.getPassword()).toString());


            if (userBO.equals(recordInDatabase)) {
                return new ValidationMessage(true);
            } else if (userBO.getUsername().equals(recordInDatabase.getUserId())) {
                validationMessage = new ValidationMessage();
                validationMessage.setUserValid(false);
            } else if (userBO.getPassword().equals(recordInDatabase.getPassword())) {
                validationMessage = new ValidationMessage();
                validationMessage.setPasswordValid(false);
            } else {
                return validationMessage = new ValidationMessage(false);
            }
        }
        return validationMessage = new ValidationMessage(false);
    }
}
