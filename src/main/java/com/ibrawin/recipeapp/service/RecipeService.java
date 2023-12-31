package com.ibrawin.recipeapp.service;

import com.ibrawin.recipeapp.dto.RecipeDTO;

import java.util.List;

public interface RecipeService {

    List<RecipeDTO> getRecipes();

    RecipeDTO getRecipeById(Long id);
}
