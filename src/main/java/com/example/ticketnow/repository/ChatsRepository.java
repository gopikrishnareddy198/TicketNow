package com.example.ticketnow.repository;

import com.example.ticketnow.model.Chats;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatsRepository extends MongoRepository<Chats,String> {

        Chats findByTicketId(String ticketId);
}
