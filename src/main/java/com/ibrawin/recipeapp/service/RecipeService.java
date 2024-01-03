package com.ibrawin.recipeapp.service;

import com.ibrawin.recipeapp.domain.Recipe;
import com.ibrawin.recipeapp.dto.RecipeClientDTO;
import com.ibrawin.recipeapp.dto.RecipeServerDTO;

import java.util.List;

public interface RecipeService {

    List<RecipeClientDTO> getRecipes();

    RecipeClientDTO getRecipeById(Long id);

    Recipe addRecipe(RecipeServerDTO recipeServerDTO);
}
