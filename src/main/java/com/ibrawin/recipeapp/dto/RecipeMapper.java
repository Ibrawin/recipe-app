package com.ibrawin.recipeapp.dto;

import com.ibrawin.recipeapp.domain.Recipe;
import org.springframework.stereotype.Component;

import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class RecipeMapper implements Function<Recipe, RecipeDTO> {

    @Override
    public RecipeDTO apply(Recipe recipe) {
        return new RecipeDTO(
                recipe.getId(),
                recipe.getDescription(),
                recipe.getPrepTime(),
                recipe.getCookTime(),
                recipe.getServings(),
                recipe.getSource(),
                recipe.getUrl(),
                recipe.getDirections(),
                recipe.getIngredients()
                        .stream()
                        .map(ingredient -> new IngredientDTO(
                                ingredient.getId(),
                                ingredient.getDescription(),
                                ingredient.getAmount(),
                                new UnitOfMeasureDTO(ingredient.getUnitOfMeasure().getId(), ingredient.getUnitOfMeasure().getDescription()))).collect(Collectors.toSet()),
                recipe.getDifficulty(),
                new NotesDTO(recipe.getNote().getId(), recipe.getNote().getNotes()),
                recipe.getCategories()
                        .stream()
                        .map(category -> new CategoryDTO(category.getId(), category.getName())).collect(Collectors.toSet()));
    }
}
