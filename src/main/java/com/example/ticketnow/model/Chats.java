package com.example.ticketnow.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
@CrossOrigin
@Data
@Document(value = "TicketLog")
public class Chats {

    @Id
    private String id;
    private String ticketId;
    private List<Message> message;

}
