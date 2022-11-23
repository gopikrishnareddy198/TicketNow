package com.example.ticketnow;

import com.example.ticketnow.model.Ticket;
import com.example.ticketnow.repo.TicketRepository;
import com.example.ticketnow.repo.UserRepository;
import com.example.ticketnow.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class SaveDataRunner implements CommandLineRunner {


    @Autowired  private UserRepository userRepository;

    @Autowired private TicketRepository ticketRepository;

    @Override
    public void run(String... args) throws Exception {
        Ticket ticket;
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


        ticket=new Ticket();
        ticket.setCreationTime(LocalDateTime.now());
        ticket.setCreationDate(LocalDate.now());
        ticket.setIDof_createdBy("gxa30590");

        ticket.setDescription("Having issues while trying to swipe the ID Card at the entrance gate");
        ticket.setTitle("Id card not working");
        ticket.setStatus("NEW");

        ticketRepository.save(ticket);
    }
}
