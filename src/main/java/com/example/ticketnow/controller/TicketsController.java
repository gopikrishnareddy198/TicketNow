package com.example.ticketnow.controller;


import com.example.ticketnow.model.Ticket;
import com.example.ticketnow.service.TicketService;
import com.example.ticketnow.service.UserService;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/ticket-now")
public class TicketsController {

    private TicketService ticketService;

    public TicketsController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping(value = "/fetch-all-tickets")
    public ResponseEntity<List<Ticket>> getAllTickets(HttpServletRequest servletRequest){
        String userId;
        List<Ticket> tickets;

        userId=servletRequest.getHeader("userid");
        tickets=ticketService.fetchAllTicketsUsingUserId(userId);


        return new ResponseEntity<List<Ticket>>(tickets, HttpStatus.OK);

    }
}
