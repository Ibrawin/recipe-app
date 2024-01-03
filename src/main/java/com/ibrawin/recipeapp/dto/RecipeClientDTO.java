package com.ibrawin.recipeapp.dto;

import com.ibrawin.recipeapp.domain.Difficulty;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class RecipeClientDTO {
    private Long id;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    private String directions;
    private Set<IngredientClientDTO> ingredients = new HashSet<>();
    private Difficulty difficulty;
    private NotesClientDTO note;
    private Set<CategoryClientDTO> categories = new HashSet<>();
}