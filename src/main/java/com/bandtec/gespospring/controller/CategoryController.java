package com.bandtec.gespospring.controller;

import com.bandtec.gespospring.model.CategoryModel;
import com.bandtec.gespospring.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @PostMapping("/create")
    public CategoryModel create(
            @RequestBody CategoryModel category
    ){
        return categoryRepository.save(category);
    }
}
