package com.bandtec.gespospring.controller;

import com.bandtec.gespospring.model.Category;
import com.bandtec.gespospring.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @PostMapping("/create")
    public Category create(
            @RequestBody Category category
    ){
        return categoryRepository.save(category);
    }
}
