package com.example.ticketnow.controller;


import com.example.ticketnow.bo.TikcetBO;
import com.example.ticketnow.model.Ticket;
import com.example.ticketnow.service.TicketService;
import com.example.ticketnow.service.UserService;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/ticket-now")
@CrossOrigin("*")
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
        userId = servletRequest.getHeader("userid");

    /*    try {
            requestBody = servletRequest.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
            userId = requestBody.substring((requestBody.length() - "userid:".length()) - 1);


            //servletRequest.getInputStream().readAllBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        tickets = ticketService.fetchAllTicketsUsingUserId(userId);

        return new ResponseEntity<List<Ticket>>(tickets, HttpStatus.OK);
        //   return new ResponseEntity<List<Ticket>>(HttpStatus.NOT_FOUND);

    }


    @PostMapping(value = "/add-new-ticket")
    public ResponseEntity<String> createTicket(@RequestBody TikcetBO ticketBO) {

        ResponseEntity responseEntity;
        Ticket ticket =
                ticketService.addATicket(ticketBO);
        if (ticket == null) {
            responseEntity = new ResponseEntity(HttpStatus.NOT_MODIFIED);
        } else
            responseEntity = new ResponseEntity(ticket.getTicketId(), HttpStatus.OK);


        return responseEntity;
    }


    @DeleteMapping(value = "/delete-a-ticket")
    public ResponseEntity<String> deleteTicket(@RequestHeader(value = "ticketId") String ticketId) {
        boolean deleted;
        deleted = ticketService.deleteTicket(ticketId);
        if (deleted)
            return new ResponseEntity<String>("Ticket Deleted Successfully", HttpStatus.OK);
        else
            return new ResponseEntity<>("Ticket Already Deleted", HttpStatus.GONE);
    }


    @GetMapping(value = "/admin/fetch-all-tickets")
    public ResponseEntity<List<Ticket>> getAllTickets() {
        return new ResponseEntity<List<Ticket>>(ticketService.getAllTickets(), HttpStatus.OK);
    }


    @PatchMapping(value = "/edit-a-ticket")
    public Ticket editATicket(@RequestBody TikcetBO tikcetBO){
        return ticketService.editTicket(tikcetBO);
    }

}
