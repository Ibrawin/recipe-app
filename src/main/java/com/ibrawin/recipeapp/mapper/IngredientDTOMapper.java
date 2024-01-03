package com.ibrawin.recipeapp.mapper;

import com.ibrawin.recipeapp.domain.Ingredient;
import com.ibrawin.recipeapp.dto.IngredientClientDTO;
import com.ibrawin.recipeapp.dto.IngredientServerDTO;

public class IngredientDTOMapper {

    private IngredientDTOMapper() {}

    public static IngredientClientDTO toIngredientDTO(Ingredient ingredient) {
        IngredientClientDTO ingredientClientDTO = new IngredientClientDTO();
        ingredientClientDTO.setId(ingredient.getId());
        ingredientClientDTO.setDescription(ingredient.getDescription());
        ingredientClientDTO.setAmount(ingredient.getAmount());
        ingredientClientDTO.setUnitOfMeasure(UnitOfMeasureMapper.toUnitOfMeasureDTO(ingredient.getUnitOfMeasure()));
        return ingredientClientDTO;
    }

    public static Ingredient toIngredient(IngredientServerDTO severDTO) {
        Ingredient ingredient = new Ingredient();
        ingredient.setDescription(severDTO.getDescription());
        ingredient.setAmount(severDTO.getAmount());
        ingredient.setUnitOfMeasure(UnitOfMeasureMapper.toUnitOfMeasure(severDTO.getUnitOfMeasure()));
        return ingredient;
    }
}