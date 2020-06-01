package com.bandtec.gespospring.service.Category;

import com.bandtec.gespospring.entity.table.Category;
import com.bandtec.gespospring.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Transactional
@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void save(List<Category> categories){
        categoryRepository.saveAll(categories);
    }

    @Override
    public List<Category> find(Integer id) {
        Category cat = new Category();
        cat.setId(id);

        return categoryRepository.findAll(Example.of(cat));
    }

    @Override
    public Boolean update(Category category) {
        return categoryRepository.findById(category.getId()).map(cat -> {
            cat.setDsCategory(category.getDsCategory());
            categoryRepository.save(cat);

            return true;
        }).orElse(false);
    }

    @Override
    public Boolean delete(Integer id) {
        return categoryRepository.findById(id).map(cat -> {
            categoryRepository.deleteById(id);
            return true;
        }).orElse(false);
    }
}
