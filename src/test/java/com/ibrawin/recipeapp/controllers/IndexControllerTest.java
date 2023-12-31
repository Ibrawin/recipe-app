package com.ibrawin.recipeapp.controllers;

import com.ibrawin.recipeapp.domain.Recipe;
import com.ibrawin.recipeapp.dto.RecipeDTO;
import com.ibrawin.recipeapp.dto.RecipeMapper;
import com.ibrawin.recipeapp.service.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


class IndexControllerTest {

    @Mock
    private Model model;

    @Mock
    private RecipeService recipeService;

    @Mock
    private RecipeMapper recipeMapper;

    private IndexController indexController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        indexController = new IndexController(recipeService);
    }

    @Test
    void mockMvc() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(model().attributeExists("recipes"));
    }

    @Test
    void getIndexPage() {
        // Given
        List<RecipeDTO> recipes = Stream.of(new Recipe(), new Recipe()).map(recipeMapper).collect(Collectors.toList());
        when(recipeService.getRecipes())
                .thenReturn(recipes);
        ArgumentCaptor<List<Recipe>> argumentCaptor = ArgumentCaptor.forClass(List.class);

        // When
        String controllerValue = indexController.getIndexPage(model);


        // Then
        assertEquals("index", controllerValue);
        verify(recipeService, times(1)).getRecipes();
        verify(model, times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());
        List<Recipe> listInController = argumentCaptor.getValue();
        assertEquals(2, listInController.size());

    }
}