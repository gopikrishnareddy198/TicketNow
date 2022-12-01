package com.example.ticketnow.repository;

import com.example.ticketnow.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends MongoRepository<Category,String> {

    Category findByCategory(String category);

}
