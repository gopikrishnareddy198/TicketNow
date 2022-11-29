package com.example.ticketnow.dao;

import com.example.ticketnow.model.Comment;

import java.util.List;

public interface ICommentsDAO {

    List<Comment> getAllCommentsByTicketId(String ticektId);
}
