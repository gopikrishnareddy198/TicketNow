package com.example.ticketnow.service;

import com.example.ticketnow.bo.TikcetBO;
import com.example.ticketnow.model.Ticket;

import java.util.List;

public interface TicketService {
    List<Ticket> fetchAllTicketsUsingUserId(String userId);

    Ticket    addATicket(TikcetBO tikcetBO);
    List<Ticket> getAllTickets();

    boolean deleteTicket(String ticketId);
}
