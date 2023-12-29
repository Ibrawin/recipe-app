package com.ibrawin.recipeapp.service;

import com.ibrawin.recipeapp.domain.Difficulty;
import com.ibrawin.recipeapp.domain.Recipe;
import com.ibrawin.recipeapp.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RecipeServiceImplTest {

    private RecipeService recipeService;

    @Mock
    private RecipeRepository recipeRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository);
    }

    @Test
    void getRecipes() {
        Recipe recipe1 = new Recipe();
        recipe1.setId(1L);
        recipe1.setDifficulty(Difficulty.MEDIUM);
        recipe1.setDescription("Hello world");
        recipe1.setDirections("Do this");

        Recipe recipe2 = new Recipe();
        recipe2.setId(2L);
        recipe2.setDifficulty(Difficulty.EASY);
        recipe2.setDescription("ABC DEF");
        recipe2.setDirections("Do that");

        List<Recipe> recipes = List.of(recipe1, recipe2);

        when(recipeRepository.findAll()).thenReturn(recipes);

        assertEquals(2, recipeService.getRecipes().size());
        verify(recipeRepository, times(1)).findAll();
    }

    @ParameterizedTest
    @ValueSource(longs = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    void getRecipeByIdSuccess(Long id) {
        Recipe recipe = new Recipe();
        recipe.setId(id);
        Optional<Recipe> optionalRecipe = Optional.of(recipe);
        when(recipeRepository.findById(id))
                .thenReturn(optionalRecipe);

        Recipe returnedRecipe = recipeService.getRecipeById(id);

        assertEquals(id, returnedRecipe.getId());
        verify(recipeRepository, times(1)).findById(id);
        verify(recipeRepository, never()).findAll();
    }

    @Test
    void getRecipeByIdFailure() {
        Recipe recipe = new Recipe();
        recipe.setId(null);
        Optional<Recipe> optionalRecipe = Optional.of(recipe);
        when(recipeRepository.findById(null))
                .thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> recipeService.getRecipeById(null));
    }
}