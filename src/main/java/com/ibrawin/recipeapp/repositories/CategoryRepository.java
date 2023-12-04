package com.ibrawin.recipeapp.repositories;

import com.ibrawin.recipeapp.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
