package com.example.ticketnow.repository;

import com.example.ticketnow.model.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends MongoRepository<Ticket, Integer> {

    Ticket findByTicketId(String i);

//    List<Ticket> findAllByIDof_createdBy(String userId);




}