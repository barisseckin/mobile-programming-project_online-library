package com.demo.onlinelibrary.repository;

import com.demo.onlinelibrary.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
