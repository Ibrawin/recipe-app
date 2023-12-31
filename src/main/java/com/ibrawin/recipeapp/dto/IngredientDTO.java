package com.ibrawin.recipeapp.dto;

import java.math.BigDecimal;

public record IngredientDTO(Long id, String description, BigDecimal amount, UnitOfMeasureDTO unitOfMeasure) {
}
