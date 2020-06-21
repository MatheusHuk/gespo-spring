package com.bandtec.gespospring.service;

import com.bandtec.gespospring.entity.table.Category;
import com.bandtec.gespospring.repository.CategoryRepository;
import com.bandtec.gespospring.service.Category.CategoryService;
import com.bandtec.gespospring.service.Category.CategoryServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryServiceImplTest {

    Class serviceClass = CategoryServiceImpl.class;

    @Autowired
    CategoryService categoryService;

    @MockBean
    CategoryRepository categoryRepository;

    List<Category> categories = new ArrayList<>(Arrays.asList(new Category(), new Category(), new Category()));

    Category category = new Category();

    @Test
    void testConfigService() {
        assertTrue(this.serviceClass.isAnnotationPresent(Service.class));
        assertTrue(this.serviceClass.isAnnotationPresent(Transactional.class));
    }

    @Test
    void findById() {
        this.category.setId(1);
        Mockito.when(this.categoryRepository.findById(1)).thenReturn(Optional.of(this.category));
        Category categoryFounded = this.categoryService.findById(1);

        assertEquals(this.category, categoryFounded);
    }

    @Test
    void findByIdWhenCategoryNotFound() {
        this.category.setId(1);
        Mockito.when(this.categoryRepository.findById(1)).thenReturn(Optional.empty());

        assertNull(this.categoryService.findById(1));
    }

    @Test
    void notFindById() {
        Category category = new Category();
        category.setId(2);
        Mockito.when(categoryRepository.findById(1)).thenReturn(Optional.of(this.category));
        Category categoryFounded = categoryService.findById(2);

        assertNotEquals(this.category, categoryFounded);
    }

    @Test
    void update() {
        this.category.setId(1);
        Mockito.when(this.categoryRepository.findById(this.category.getId())).thenReturn(Optional.of(this.category));

        assertTrue(this.categoryService.update(this.category));
        Mockito.verify(categoryRepository, Mockito.times(1)).save(this.category);
    }

    @Test
    void updateWhenCategoryNotFound() {
        this.category.setId(1);
        Mockito.when(this.categoryRepository.findById(this.category.getId())).thenReturn(Optional.empty());

        assertFalse(this.categoryService.update(this.category));
        Mockito.verify(categoryRepository, Mockito.never()).save(this.category);
    }

    @Test
    void delete() {
        this.category.setId(1);
        Mockito.when(this.categoryRepository.findById(this.category.getId())).thenReturn(Optional.of(this.category));

        assertTrue(this.categoryService.delete(this.category.getId()));
        Mockito.verify(categoryRepository, Mockito.times(1)).delete(this.category);
    }

    @Test
    void deleteWhenCategoryNotFound() {
        this.category.setId(1);
        Mockito.when(this.categoryRepository.findById(this.category.getId())).thenReturn(Optional.empty());

        assertFalse(this.categoryService.delete(this.category.getId()));
        Mockito.verify(categoryRepository, Mockito.never()).delete(this.category);
    }

    @Test
    void findAll() {
        Mockito.when(this.categoryRepository.findAll()).thenReturn(this.categories);
        List<Category> allCategories = this.categoryRepository.findAll();

        assertEquals(this.categories, allCategories);
    }
}