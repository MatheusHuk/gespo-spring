package com.bandtec.gespospring.controller;

import com.bandtec.gespospring.entity.table.Category;
import com.bandtec.gespospring.service.Category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity create(
            @RequestBody List<Category> categories
    ){
        try {
            categoryService.save(categories);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping
    public ResponseEntity read(
            @RequestParam Integer id
    ){
        Category category = categoryService.findById(id);
        return category != null ? ResponseEntity.status(HttpStatus.OK).body(category) :
                ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping
    public ResponseEntity update(
            @RequestBody Category category
    ) {
        return categoryService.update(category) ? ResponseEntity.status(HttpStatus.OK).build() :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping
    public ResponseEntity delete(
            @RequestParam Integer id
    ){
        return categoryService.delete(id) ? ResponseEntity.status(HttpStatus.OK).build() :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/all")
    public ResponseEntity readAll(){
        List<Category> categories = categoryService.findAll();

        return categories.isEmpty() ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() :
                ResponseEntity.status(HttpStatus.OK).body(categories);
    }
}
