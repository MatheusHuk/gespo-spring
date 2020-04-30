package com.bandtec.gespospring.repository;

import com.bandtec.gespospring.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
