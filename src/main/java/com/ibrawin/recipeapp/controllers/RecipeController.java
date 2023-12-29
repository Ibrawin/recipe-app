package com.ibrawin.recipeapp.controllers;

import com.ibrawin.recipeapp.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RecipeController {

    private RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"/recipe/show/{id}"})
    public String getRecipePage(Model model, @PathVariable Long id) {
        model.addAttribute("recipe", recipeService.getRecipeById(id));
        return "recipe/show";
    }
}
