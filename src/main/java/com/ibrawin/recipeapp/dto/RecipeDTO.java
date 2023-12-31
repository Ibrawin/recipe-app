package com.ibrawin.recipeapp.dto;

import com.ibrawin.recipeapp.domain.Difficulty;

import java.util.Set;

public record RecipeDTO(Long id, String description, Integer prepTime, Integer cookTime, Integer servings,
                        String source, String url, String directions, Set<IngredientDTO> ingredients, Difficulty difficulty,
                        NotesDTO note, Set<CategoryDTO> categories) {
}
