package com.ibrawin.recipeapp.mapper;

import com.ibrawin.recipeapp.domain.Category;
import com.ibrawin.recipeapp.dto.CategoryClientDTO;
import com.ibrawin.recipeapp.dto.CategoryServerDTO;

public class CategoryDTOMapper {

    private CategoryDTOMapper() {}

    public static CategoryClientDTO toCategoryDTO(Category category) {
        CategoryClientDTO categoryClientDTO = new CategoryClientDTO();
        categoryClientDTO.setId(category.getId());
        categoryClientDTO.setName(category.getName());
        return categoryClientDTO;
    }

    public static Category toCategory(CategoryServerDTO severDTO) {
        Category category = new Category();
        category.setName(severDTO.getName());
        return category;
    }
}