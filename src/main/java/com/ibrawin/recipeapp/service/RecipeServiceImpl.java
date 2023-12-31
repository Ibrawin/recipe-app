package com.ibrawin.recipeapp.service;

import com.ibrawin.recipeapp.dto.RecipeDTO;
import com.ibrawin.recipeapp.dto.RecipeMapper;
import com.ibrawin.recipeapp.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeMapper recipeMapper;

    public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeMapper recipeMapper) {
        this.recipeRepository = recipeRepository;
        this.recipeMapper = recipeMapper;
    }

    @Override
    public List<RecipeDTO> getRecipes() {
        log.debug("Grabbing all recipes in the service layer");
        return recipeRepository.findAll()
                .stream()
                .map(recipeMapper)
                .collect(Collectors.toList());
    }

    @Override
    public RecipeDTO getRecipeById(Long id) {
        log.debug("Grabbing recipe with id " + id + " in the service layer");
        return recipeRepository.findById(id)
                .map(recipeMapper)
                .orElseThrow(() -> new RuntimeException("Expected Recipe Not Found."));
    }
}
