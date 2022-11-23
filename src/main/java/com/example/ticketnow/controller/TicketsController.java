package com.example.ticketnow.controller;


import com.example.ticketnow.bo.TikcetBO;
import com.example.ticketnow.model.Ticket;
import com.example.ticketnow.service.TicketService;
import com.example.ticketnow.service.UserService;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/ticket-now")
public class TicketsController {

    private TicketService ticketService;

    public TicketsController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping(value = "/fetch-all-tickets")
    public ResponseEntity<List<Ticket>> getAllTickets(HttpServletRequest servletRequest) {
        String userId;
        List<Ticket> tickets;
        String requestBody;
        //userId=servletRequest.getHeader("userid");

        try {
            requestBody = servletRequest.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
            userId = requestBody.substring((requestBody.length() - "userid:".length()) - 1);
            tickets = ticketService.fetchAllTicketsUsingUserId(userId);

            return new ResponseEntity<List<Ticket>>(tickets, HttpStatus.OK);

            //servletRequest.getInputStream().readAllBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<List<Ticket>>(HttpStatus.NOT_FOUND);

    }


    @PostMapping(value = "/add-new-ticket")
    public ResponseEntity<List<Ticket>> createTicket(@RequestBody TikcetBO ticketBO) {

        ResponseEntity responseEntity;

        if (ticketService.addATicket(ticketBO) == null) {
            responseEntity = new ResponseEntity(HttpStatus.NOT_MODIFIED);
        } else
            responseEntity = new ResponseEntity(ticketService.fetchAllTicketsUsingUserId(ticketBO.getIDof_createdBy()), HttpStatus.OK);
        return responseEntity;
    }

}
