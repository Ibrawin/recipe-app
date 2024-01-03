package com.ibrawin.recipeapp.service;

import com.ibrawin.recipeapp.domain.Recipe;
import com.ibrawin.recipeapp.dto.RecipeClientDTO;
import com.ibrawin.recipeapp.dto.RecipeServerDTO;
import com.ibrawin.recipeapp.mapper.RecipeDTOMapper;
import com.ibrawin.recipeapp.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public List<RecipeClientDTO> getRecipes() {
        log.debug("Grabbing all recipes in the service layer");
        return recipeRepository.findAll()
                .stream()
                .map(RecipeDTOMapper::toRecipeDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RecipeClientDTO getRecipeById(Long id) {
        log.debug("Grabbing recipe with id " + id + " in the service layer");
        return recipeRepository.findById(id)
                .map(RecipeDTOMapper::toRecipeDTO)
                .orElseThrow(() -> new RuntimeException("Expected Recipe Not Found."));
    }

    @Override
    public Recipe addRecipe(RecipeServerDTO recipeServerDTO) {
        return recipeRepository.save(RecipeDTOMapper.toRecipe(recipeServerDTO));
    }
}
