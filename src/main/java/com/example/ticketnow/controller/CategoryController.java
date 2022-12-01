package com.example.ticketnow.controller;

import com.example.ticketnow.model.Category;
import com.example.ticketnow.repository.CategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {


    private CategoryRepository categoryRepository;

    @GetMapping(value = "/find-user-by-category")
    public ResponseEntity<Category> getUsernnameForCategory(@RequestHeader String categoryName){

        return new ResponseEntity<Category>(categoryRepository.findByCategory(categoryName), HttpStatus.OK);

    }
}
