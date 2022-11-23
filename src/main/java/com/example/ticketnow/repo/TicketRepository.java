package com.example.ticketnow.repo;

import com.example.ticketnow.model.Ticket;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends MongoRepository<Ticket, Integer> {

    Ticket findByTicketId(Integer i);

//    List<Ticket> findAllByIDof_createdBy(String userId);

}