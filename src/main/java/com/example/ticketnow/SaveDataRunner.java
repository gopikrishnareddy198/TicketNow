package com.example.ticketnow;

import com.example.ticketnow.repo.UserRepository;
import com.example.ticketnow.users.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.HashSet;
import java.util.Set;

@Component
public class SaveDataRunner implements CommandLineRunner {


    @Autowired  private UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception {
        User user,user2;
        String ecodedPassword;
      /*  Set<String> rolesForGopi,rolesForKhomsun;

        user=new User();
        user.setUserId("gxa30590");
        user.setUsername("Gopi");
        ecodedPassword=Base64.getEncoder().encodeToString("1234".getBytes());
        user.setPassword(ecodedPassword);

        rolesForGopi=new HashSet<>();
        rolesForGopi.add("ROLE_USER");
        rolesForGopi.add("ROLE_ADMIN");

        user.setRoles(rolesForGopi);


        user2=new User();
        user2.setUserId("kxa30590");
        user2.setUsername("Khomsun");
        ecodedPassword=Base64.getEncoder().encodeToString("1234".getBytes());
        user2.setPassword(ecodedPassword);

        rolesForKhomsun=new HashSet<>();
        rolesForKhomsun.add("ROLE_ADMIN");
        user2.setRoles(rolesForKhomsun);


        userRepository.save(user);
        userRepository.save(user2);*/

    }
}
