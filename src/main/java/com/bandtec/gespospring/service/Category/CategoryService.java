package com.bandtec.gespospring.service.Category;

import com.bandtec.gespospring.entity.table.Category;

import java.util.List;

public interface CategoryService {
    void save(List<Category> categories);
    Category findById(Integer id);
    Boolean update(Category categories);
    Boolean delete(Integer id);
}
