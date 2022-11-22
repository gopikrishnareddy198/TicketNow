package com.example.ticketnow.controller;


import com.example.ticketnow.service.UserService;
import com.example.ticketnow.service.UserServiceImpl;
import com.example.ticketnow.users.bo.UserBO;
import com.example.ticketnow.users.model.ValidationMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/ticket-now/auth")
public class UserController {


    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/signin")
    public ResponseEntity<ValidationMessage> sigIn(@RequestBody UserBO userBO){

       if(userService.validateUser(userBO).isUsernameAndPasswordMatches()==false)
           return new ResponseEntity<ValidationMessage>(HttpStatus.UNAUTHORIZED);
        else
            return new ResponseEntity<ValidationMessage>(userService.validateUser(userBO),HttpStatus.OK);
    }

}
