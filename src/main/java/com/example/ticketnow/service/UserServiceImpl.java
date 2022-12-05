package com.example.ticketnow.service;

import com.example.ticketnow.model.Category;
import com.example.ticketnow.repository.CategoryRepository;
import com.example.ticketnow.repository.UserRepository;
import com.example.ticketnow.bo.UserBO;
import com.example.ticketnow.model.User;
import com.example.ticketnow.model.ValidationMessage;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Optional;

@Service


public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private CategoryRepository categoryRepository;

    public UserServiceImpl(UserRepository userRepository, CategoryRepository categoryRepository) {
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
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

            if (recordInDatabase.getPassword() != null) {
                String decodedPassword =
                        new String(Base64.getDecoder().decode(recordInDatabase.getPassword()));
                recordInDatabase.setPassword(decodedPassword);
            }

            if (userBO.equals(recordInDatabase)) {
                validationMessage = new ValidationMessage(true);
                validationMessage.setUserId(recordInDatabase.getUserId());
                validationMessage.setUsername(recordInDatabase.getUsername());
                validationMessage.setRoles(recordInDatabase.getRoles());
                return validationMessage;
            } else if (userBO.getUserId().equals(recordInDatabase.getUserId()) == false) {
                validationMessage = new ValidationMessage();
                validationMessage.setUserIdValid(false);
                validationMessage.setUserId(userBO.getUserId());
            } else if (userBO.getPassword().equals(recordInDatabase.getPassword()) == false) {
                validationMessage = new ValidationMessage();
                validationMessage.setPasswordValid(false);
            } else {
                return validationMessage = new ValidationMessage(false);
            }
        }
        return validationMessage = new ValidationMessage(false);
    }


    @Override
    public boolean checkIfTheUserIsPresent(String userid) {
        Optional<User> optionalUser;

        optionalUser = userRepository.findById(userid);

        if (optionalUser.isPresent())
            return true;
        else return false;

    }


    public User createUserAndCategory(UserBO userBO, String category) {
        User user = new User();


        BeanUtils.copyProperties(userBO, user);
        user.setPassword(Base64.getEncoder().encode(userBO.getPassword().getBytes()).toString());
        if(category!="User"){
            Category category1;
            category1=new Category();

            category1.setCategory(category);
            category1.setUserId(user.getUserId());
            category1.setUsername(user.getUsername());

            categoryRepository.save(category1);
        }
        return userRepository.save(user);

    }


    @Override
    public boolean deleteUserUsingId(String userid) {
       Optional<User> optionalUser;

        boolean deleted=false;
        try {
            optionalUser=userRepository.findById(userid);
           if( optionalUser.isPresent()) {
               userRepository.delete(optionalUser.get());
               categoryRepository.deleteAll(categoryRepository.findByUserId(userid));
               deleted = true;
           }
        }catch (Exception e){
            e.printStackTrace();
        }
        return deleted;
    }
}
