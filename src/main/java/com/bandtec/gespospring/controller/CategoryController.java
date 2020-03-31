package com.bandtec.gespospring.controller;

import com.bandtec.gespospring.model.Category;
import com.bandtec.gespospring.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/search-all")
    public List<Category> searchAll(){
        return  categoryRepository.findAll();
    }

    @GetMapping("/search/{id}")
    public Category searchById(
            @RequestParam(name = "id") Integer id
    ){
        return  categoryRepository.findById(id).get();
    }

    @PutMapping("/update/{id}")
    public Category updateCategory(
            @RequestBody Category category,
            @PathVariable Integer id
    ) {
        return categoryRepository.findById(id).map(cat -> {
            cat.setDsCategory(category.getDsCategory());
            return categoryRepository.save(cat);
        }).orElseGet(() -> {
            category.setId(id);
            return categoryRepository.save(category);
        });
    }

    @DeleteMapping("/delete")
    public void delete(
            @RequestParam(name = "id") Integer id
    ){;
        categoryRepository.deleteById(id);
    }
}
