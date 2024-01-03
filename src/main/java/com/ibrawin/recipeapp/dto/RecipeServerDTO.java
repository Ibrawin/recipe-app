package com.ibrawin.recipeapp.dto;

import com.ibrawin.recipeapp.domain.Difficulty;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class RecipeServerDTO {
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    private String directions;
    private Set<IngredientServerDTO> ingredients = new HashSet<>();
    private Difficulty difficulty;
    private NotesServerDTO note;
    private Set<CategoryServerDTO> categories = new HashSet<>();
}