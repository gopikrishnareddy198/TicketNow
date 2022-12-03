package com.example.ticketnow.bo;

import com.example.ticketnow.model.Message;
import lombok.Data;

import java.util.List;

@Data
public class ChatBO {


    private String ticketId;
    private MessageBO message;
}
