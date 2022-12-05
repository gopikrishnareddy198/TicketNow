package com.example.ticketnow.controller;


import com.example.ticketnow.model.User;
import com.example.ticketnow.service.UserService;
import com.example.ticketnow.bo.UserBO;
import com.example.ticketnow.model.ValidationMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@CrossOrigin
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


    @PostMapping(value = "/validate-user")
    public ResponseEntity<Boolean> validateUserId(@RequestHeader String userid){

      return   new ResponseEntity<Boolean>(userService.checkIfTheUserIsPresent(userid),HttpStatus.OK);

    }

    @PostMapping(value = "/add-user")
    public ResponseEntity<User> signUp(@RequestHeader String isadmin, @RequestHeader String category, @RequestBody UserBO userBO){


                if(isadmin.equals("Yes"))
                    userBO.setRoles(Set.of("ROLE_ADMIN"));
                else if(isadmin.equals("No"))
                    userBO.setRoles(Set.of("ROLE_USER"));
            return  new ResponseEntity<User>(userService.createUserAndCategory(userBO,category),HttpStatus.OK);

    }


    /*@DeleteMapping(value = "/delete-user")
    public ResponseEntity<Boolean> deleteAUser(@RequestHeader String userid){
        userService.deleteUserUsingId(userid);
    }
*/

}
