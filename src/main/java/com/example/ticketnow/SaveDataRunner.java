package com.example.ticketnow;

import com.example.ticketnow.model.Comment;
import com.example.ticketnow.model.Ticket;
import com.example.ticketnow.repo.CommentsRepository;
import com.example.ticketnow.repo.TicketRepository;
import com.example.ticketnow.repo.UserRepository;
import com.example.ticketnow.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Component
public class SaveDataRunner implements CommandLineRunner {


    @Autowired  private UserRepository userRepository;

    @Autowired private TicketRepository ticketRepository;

    @Autowired private CommentsRepository commentsRepository;

    @Override
    public void run(String... args) throws Exception {
        Ticket ticket;
        User user,user2;
        String ecodedPassword;
        List<Comment> commentList;
      /*  Set<String> rolesForGopi,rolesForKhomsun;

        user=new User();
        user.setUserId("sxd30590");
        user.setUsername("Suhas");
        ecodedPassword= Base64.getEncoder().encodeToString("1234".getBytes());
        user.setPassword(ecodedPassword);

        rolesForGopi=new HashSet<>();
        rolesForGopi.add("ROLE_USER");
        //rolesForGopi.add("ROLE_ADMIN");

        user.setRoles(rolesForGopi);

        user2=new User();
        user2.setUserId("axa30590");
        user2.setUsername("Adam Robins");
        ecodedPassword=Base64.getEncoder().encodeToString("1234".getBytes());
        user2.setPassword(ecodedPassword);

        rolesForKhomsun=new HashSet<>();
        rolesForKhomsun.add("ROLE_ADMIN");
        user2.setRoles(rolesForKhomsun);


        userRepository.save(user);
        userRepository.save(user2);
*/

/*
        ticket=new Ticket();
        ticket.setCreationTime(LocalDateTime.now());
        ticket.setCreationDate(LocalDate.now());
        ticket.setIDof_createdBy("axa30590");

        ticket.setDescription("This is description 2");
        ticket.setTitle("Title 2");
        ticket.setStatus("NEW");

        commentList =new ArrayList<>();

        Comment comment =new Comment();
        comment.setComment("Hey I just started working on the comment");
        comment.setCommentedAt(LocalDateTime.now());
        comment.setIdOfTheUserWhoCommentedIt("axa30590");
        comment.setNameOfTheUserWhoCommented("Adam Robins");

        commentsRepository.save(comment);

        commentList.add(comment);

        ticket.setIdOfComment(List.of(comment.getId()));
        ticketRepository.save(ticket);
*/
    }
}
