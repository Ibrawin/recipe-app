package com.ibrawin.recipeapp.repositories;

import com.ibrawin.recipeapp.domain.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
