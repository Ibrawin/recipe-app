package com.ibrawin.recipeapp.dto;

import com.ibrawin.recipeapp.domain.UnitOfMeasure;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UnitOfMeasureMapper implements Function<UnitOfMeasure, UnitOfMeasureDTO> {

    @Override
    public UnitOfMeasureDTO apply(UnitOfMeasure unitOfMeasure) {
        return new UnitOfMeasureDTO(unitOfMeasure.getId(), unitOfMeasure.getDescription());
    }
}
