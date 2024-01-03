package com.ibrawin.recipeapp.controllers;

import com.ibrawin.recipeapp.domain.Recipe;
import com.ibrawin.recipeapp.dto.RecipeClientDTO;
import com.ibrawin.recipeapp.dto.RecipeServerDTO;
import com.ibrawin.recipeapp.service.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@Controller
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"/recipe/show/{id}"})
    public String getRecipePage(Model model, @PathVariable Long id) {
        model.addAttribute("recipe", recipeService.getRecipeById(id));
        return "recipe/show";
    }

    @RequestMapping("/recipe/new")
    public String newRecipe(Model model) {
        model.addAttribute("recipe", new RecipeClientDTO());
        return "recipe/recipe-form";
    }

    @RequestMapping(value = "recipe", method = RequestMethod.POST)
    public String postRecipe(@ModelAttribute RecipeServerDTO recipeServerDTO) {
        Recipe recipe = recipeService.addRecipe(recipeServerDTO);
        return "redirect:/recipe/show/" + recipe.getId();
    }
}
