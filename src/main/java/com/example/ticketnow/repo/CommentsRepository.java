package com.example.ticketnow.repo;

import com.example.ticketnow.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsRepository extends MongoRepository<Comment,String> {


}
