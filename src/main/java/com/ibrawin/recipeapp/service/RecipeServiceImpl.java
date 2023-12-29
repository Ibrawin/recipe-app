package com.ibrawin.recipeapp.service;

import com.ibrawin.recipeapp.domain.Recipe;
import com.ibrawin.recipeapp.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public List<Recipe> getRecipes() {
        log.debug("Grabbing all recipes in the service layer");
        return recipeRepository.findAll();
    }

    @Override
    public Recipe getRecipeById(Long id) {
        log.debug("Grabbing recipe with id " + id + " in the service layer");
        return recipeRepository.findById(id).orElseThrow(() -> new RuntimeException("Expected Recipe Not Found."));
    }
}
