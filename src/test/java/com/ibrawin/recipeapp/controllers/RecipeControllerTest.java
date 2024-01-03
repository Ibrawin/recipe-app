package com.ibrawin.recipeapp.controllers;

import com.ibrawin.recipeapp.domain.Notes;
import com.ibrawin.recipeapp.domain.Recipe;
import com.ibrawin.recipeapp.dto.RecipeClientDTO;
import com.ibrawin.recipeapp.service.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class RecipeControllerTest {

    @Mock
    private RecipeService recipeService;

    @Mock
    private Model model;

    private RecipeController recipeController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        recipeController = new RecipeController(recipeService);
    }


    @ParameterizedTest
    @ValueSource(longs = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    void getRecipePage(Long id) {
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        recipe.setNote(new Notes());

        RecipeClientDTO recipeClientDTO = new RecipeClientDTO();
        when(recipeService.getRecipeById(id))
                .thenReturn(recipeClientDTO);
        ArgumentCaptor<RecipeClientDTO> argumentCaptorRecipe = ArgumentCaptor.forClass(RecipeClientDTO.class);

        String viewName = recipeController.getRecipePage(model, id);

        assertEquals("recipe/show", viewName);
        verify(recipeService, times(1)).getRecipeById(anyLong());
        verify(model, times(1)).addAttribute(eq("recipe"), argumentCaptorRecipe.capture());
        assertEquals(recipeClientDTO, argumentCaptorRecipe.getValue());
    }

    @Test
    void mockMvc() throws Exception {
        RecipeClientDTO recipeClientDTO = new RecipeClientDTO();

        when(recipeService.getRecipeById(anyLong())).thenReturn(recipeClientDTO);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(recipeController).build();

        mockMvc.perform(get("/recipe/show/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/show"))
                .andExpect(model().attributeExists("recipe"));
    }
}