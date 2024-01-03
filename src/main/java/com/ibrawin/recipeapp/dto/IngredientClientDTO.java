package com.ibrawin.recipeapp.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class IngredientClientDTO {
    private Long id;
    private String description;
    private BigDecimal amount;
    private UnitOfMeasureClientDTO unitOfMeasure;

}
