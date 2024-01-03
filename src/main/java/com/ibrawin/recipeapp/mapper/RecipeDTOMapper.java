package com.ibrawin.recipeapp.mapper;

import com.ibrawin.recipeapp.domain.Recipe;
import com.ibrawin.recipeapp.dto.*;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class RecipeDTOMapper{

    private RecipeDTOMapper(){}

    public static RecipeClientDTO toRecipeDTO(Recipe recipe) {
        RecipeClientDTO recipeClientDTO = new RecipeClientDTO();
        recipeClientDTO.setId(recipe.getId());
        recipeClientDTO.setDescription(recipe.getDescription());
        recipeClientDTO.setPrepTime(recipe.getPrepTime());
        recipeClientDTO.setCookTime(recipe.getCookTime());
        recipeClientDTO.setServings(recipe.getServings());
        recipeClientDTO.setSource(recipe.getSource());
        recipeClientDTO.setUrl(recipe.getUrl());
        recipeClientDTO.setDirections(recipe.getDirections());
        recipeClientDTO.setIngredients(recipe.getIngredients()
                .stream()
                .map(IngredientDTOMapper::toIngredientDTO)
                .collect(Collectors.toSet()));
        recipeClientDTO.setDifficulty(recipe.getDifficulty());
        recipeClientDTO.setNote(NoteDTOMapper.toNotesDTO(recipe.getNote()));
        recipeClientDTO.setCategories(recipe.getCategories()
                .stream()
                .map(CategoryDTOMapper::toCategoryDTO)
                .collect(Collectors.toSet()));
        return recipeClientDTO;
    }

    public static Recipe toRecipe(RecipeServerDTO serverDTO) {
        Recipe recipe = new Recipe();
        recipe.setDescription(serverDTO.getDescription());
        recipe.setPrepTime(serverDTO.getPrepTime());
        recipe.setCookTime(serverDTO.getCookTime());
        recipe.setServings(serverDTO.getServings());
        recipe.setSource(serverDTO.getSource());
        recipe.setUrl(serverDTO.getUrl());
        recipe.setDirections(serverDTO.getDirections());
        recipe.setIngredients(serverDTO.getIngredients()
                .stream()
                .map(IngredientDTOMapper::toIngredient)
                .collect(Collectors.toSet()));
        recipe.setDifficulty(serverDTO.getDifficulty());
        recipe.setNote(NoteDTOMapper.toNotes(serverDTO.getNote()));
        recipe.setCategories(serverDTO.getCategories()
                .stream()
                .map(CategoryDTOMapper::toCategory)
                .collect(Collectors.toSet()));
        return recipe;
    }
}
