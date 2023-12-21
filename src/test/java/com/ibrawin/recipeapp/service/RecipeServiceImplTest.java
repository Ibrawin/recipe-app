package com.ibrawin.recipeapp.service;

import com.ibrawin.recipeapp.domain.Difficulty;
import com.ibrawin.recipeapp.domain.Recipe;
import com.ibrawin.recipeapp.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
}