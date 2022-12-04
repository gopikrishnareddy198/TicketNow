package com.example.ticketnow.controller;

import com.example.ticketnow.model.Category;
import com.example.ticketnow.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping(value = "/find-user-by-category")
    public ResponseEntity<List<Category>> getUsernnameForCategory(@RequestHeader(value = "category") String categoryName){

        return new ResponseEntity<List<Category>>(categoryRepository.findByCategory(categoryName), HttpStatus.OK);

    }
}
