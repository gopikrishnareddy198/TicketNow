package com.example.ticketnow.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Document(value = "tickets")
public class Ticket {

    @Id
    private String ticketId;
    private String title;
    private String description;
    private String status;
    private String priority;

    private String IDof_createdBy;

    private LocalDate creationDate;
    private LocalDateTime creationTime;

    private String IDof_assignedTo;

    private List<String> idOfComment;
    private String category;

    @Transient
    public static final String SEQUENCE_NAME="ticket_sequence";

}
