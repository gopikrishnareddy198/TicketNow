package com.example.ticketnow.dao;

import com.example.ticketnow.model.Comment;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class CommentDAOImpl implements ICommentsDAO{



    MongoTemplate mongoTemplate;

    public CommentDAOImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<Comment> getAllCommentsByTicketId(String ticektId) {
        Query  query;

        query=new Query();
        query.addCriteria(Criteria.where("ticketId").in(ticektId).lt(LocalDateTime.now()));

        return         mongoTemplate.find(query,Comment.class);
    }
}
