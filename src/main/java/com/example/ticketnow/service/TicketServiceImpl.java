package com.example.ticketnow.service;

import com.example.ticketnow.model.Ticket;
import com.example.ticketnow.repo.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    private TicketRepository ticketRepository;

    private MongoTemplate mongoTemplate;


    @Autowired
    public void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<Ticket> fetchAllTicketsUsingUserId(String userId) {
        List<String> idOfUser;
        Query query;
        List<Ticket> tickets;

        query = new Query();

        idOfUser = new ArrayList<String>(2);
        idOfUser.add(userId);

        query.addCriteria(Criteria.where("IDof_createdBy").in(userId));

        tickets = mongoTemplate.find(query, Ticket.class);
        return tickets;
    }
}
