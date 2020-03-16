package com.bandtec.gespospring.repository;

import com.bandtec.gespospring.model.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryModel, Integer> {
}
