package com.example.ticketnow.service;

import com.example.ticketnow.model.Ticket;

import java.util.List;

public interface TicketService {
    List<Ticket> fetchAllTicketsUsingUserId(String userId);
}
