package com.ibrawin.recipeapp.mapper;

import com.ibrawin.recipeapp.domain.UnitOfMeasure;
import com.ibrawin.recipeapp.dto.UnitOfMeasureClientDTO;
import com.ibrawin.recipeapp.dto.UnitOfMeasureServerDTO;

public class UnitOfMeasureMapper {

    private UnitOfMeasureMapper() {}

    public static UnitOfMeasureClientDTO toUnitOfMeasureDTO(UnitOfMeasure unitOfMeasure) {
        UnitOfMeasureClientDTO unitOfMeasureClientDTO = new UnitOfMeasureClientDTO();
        unitOfMeasureClientDTO.setId(unitOfMeasureClientDTO.getId());
        unitOfMeasureClientDTO.setDescription(unitOfMeasureClientDTO.getDescription());
        return unitOfMeasureClientDTO;
    }

    public static UnitOfMeasure toUnitOfMeasure(UnitOfMeasureServerDTO severDTO) {
        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setDescription(severDTO.getDescription());
        return unitOfMeasure;
    }
}