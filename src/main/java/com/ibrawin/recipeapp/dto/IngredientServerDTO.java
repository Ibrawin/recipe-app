package com.ibrawin.recipeapp.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class IngredientServerDTO {
    private String description;
    private BigDecimal amount;
    private UnitOfMeasureServerDTO unitOfMeasure;

}
