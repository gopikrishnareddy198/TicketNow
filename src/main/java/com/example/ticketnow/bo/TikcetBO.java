package com.example.ticketnow.bo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class TikcetBO {

    //@JsonIgnore
    private String ticketId;
    private String title;
    private String description;
    private String status;
    private String priority;

    private String IDof_createdBy;

    private LocalDate creationDate;
    private LocalDateTime creationTime;

    private String IDof_assignedTo;

    private String category;



}
