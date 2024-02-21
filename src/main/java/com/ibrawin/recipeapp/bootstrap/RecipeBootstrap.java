package com.ibrawin.recipeapp.bootstrap;

import com.ibrawin.recipeapp.domain.*;
import com.ibrawin.recipeapp.repositories.CategoryRepository;
import com.ibrawin.recipeapp.repositories.RecipeRepository;
import com.ibrawin.recipeapp.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class RecipeBootstrap implements CommandLineRunner {

    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final CategoryRepository categoryRepository;

    public RecipeBootstrap(RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository, CategoryRepository categoryRepository) {
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        recipeRepository.saveAll(getRecipes());
        log.debug("Loading bootstrap...");
    }

    private List<Recipe> getRecipes() {
        log.debug("Creating entities...");
        List<Recipe> recipes = new ArrayList<>(2);

        UnitOfMeasure teaspoon = getUnitOfMeasure("Teaspoon");
        UnitOfMeasure tablespoon = getUnitOfMeasure("Tablespoon");
        UnitOfMeasure cup = getUnitOfMeasure("Cup");
        UnitOfMeasure pinch = getUnitOfMeasure("Pinch");
        UnitOfMeasure ounce = getUnitOfMeasure("Ounce");
        UnitOfMeasure each = getUnitOfMeasure("Each");
        UnitOfMeasure dash = getUnitOfMeasure("Dash");
        UnitOfMeasure pint = getUnitOfMeasure("Pint");

        Category american = getCategory("American");
        Category italian = getCategory("Italian");
        Category mexican = getCategory("Mexican");
        Category fastFood = getCategory("Fast Food");

        Recipe guacRecipe = new Recipe();
        guacRecipe.setDescription("Perfect Guacamole");
        guacRecipe.setPrepTime(10);
        guacRecipe.setCookTime(0);
        guacRecipe.setDifficulty(Difficulty.EASY);
        guacRecipe.setDirections("""
                1. Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon
                2. Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)
                3. Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.
                Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.
                Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.
                4. Cover with plastic and chill to store: Place plastic wrap on the surface of the guacamole cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.
                Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.
                                
                                
                Read more: http://www.simplyrecipes.com/recipes/perfect_guacamole/#ixzz4jvpiV9Sd
                """);
        Note guacNotes = new Note();
        guacNotes.setNotes("""
                For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.
                Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). Try guacamole with added pineapple, mango, or strawberries.
                The simplest version of guacamole is just mashed avocados with salt. Don't let the lack of availability of other ingredients stop you from making guacamole.
                To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great.
                                
                                
                Read more: http://www.simplyrecipes.com/recipes/perfect_guacamole/#ixzz4jvoun5ws""");

        guacRecipe.setNote(guacNotes);

        guacRecipe.addIngredient(new Ingredient("ripe avocados", new BigDecimal(2), each))
                .addIngredient(new Ingredient("Kosher salt", new BigDecimal(".5"), teaspoon))
                .addIngredient(new Ingredient("fresh lime juice or lemon juice", new BigDecimal(2), tablespoon))
                .addIngredient(new Ingredient("minced red onion or thinly sliced green onion", new BigDecimal(2), tablespoon))
                .addIngredient(new Ingredient("serrano chiles, stems and seeds removed, minced", new BigDecimal(2), each))
                .addIngredient(new Ingredient("Cilantro", new BigDecimal(2), tablespoon))
                .addIngredient(new Ingredient("freshly grated black pepper", new BigDecimal(2), dash))
                .addIngredient(new Ingredient("ripe tomato, seeds and pulp removed, chopped", new BigDecimal(".5"), each));


        guacRecipe.getCategories().add(american);
        guacRecipe.getCategories().add(mexican);

        guacRecipe.setUrl("http://www.simplyrecipes.com/recipes/perfect_guacamole/");
        guacRecipe.setServings(4);
        guacRecipe.setSource("Simply Recipes");

        recipes.add(guacRecipe);


        Recipe tacosRecipe = new Recipe();
        tacosRecipe.setDescription("Spicy Grilled Chicken Taco");
        tacosRecipe.setCookTime(9);
        tacosRecipe.setPrepTime(20);
        tacosRecipe.setDifficulty(Difficulty.MEDIUM);

        tacosRecipe.setDirections("""
                1. Prepare a gas or charcoal grill for medium-high, direct heat.
                2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.
                Set aside to marinate while the grill heats and you prepare the rest of the toppings.
                                
                                
                3. Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.
                4. Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.
                Wrap warmed tortillas in a tea towel to keep them warm until serving.
                5. Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.+
                                
                                
                Read more: http://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/#ixzz4jvtrAnNm""");

        Note tacoNotes = new Note();
        tacoNotes.setNotes("""
                We have a family motto and it is this: Everything goes better in a tortilla.
                Any and every kind of leftover can go inside a warm tortilla, usually with a healthy dose of pickled jalapenos. I can always sniff out a late-night snacker when the aroma of tortillas heating in a hot pan on the stove comes wafting through the house.
                Today’s tacos are more purposeful – a deliberate meal instead of a secretive midnight snack!
                First, I marinate the chicken briefly in a spicy paste of ancho chile powder, oregano, cumin, and sweet orange juice while the grill is heating. You can also use this time to prepare the taco toppings.
                Grill the chicken, then let it rest while you warm the tortillas. Now you are ready to assemble the tacos and dig in. The whole meal comes together in about 30 minutes!
                                
                                
                Read more: http://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/#ixzz4jvu7Q0MJ""");
        tacoNotes.setRecipe(tacosRecipe);
        tacosRecipe.setNote(tacoNotes);


        tacosRecipe.addIngredient(new Ingredient("Ancho Chili Powder", new BigDecimal(2), tablespoon))
                .addIngredient(new Ingredient("Dried Oregano", new BigDecimal(1), teaspoon))
                .addIngredient(new Ingredient("Dried Cumin", new BigDecimal(1), teaspoon))
                .addIngredient(new Ingredient("Sugar", new BigDecimal(1), teaspoon))
                .addIngredient(new Ingredient("Salt", new BigDecimal(".5"), teaspoon))
                .addIngredient(new Ingredient("Clove of Garlic, Choppedr", new BigDecimal(1), each))
                .addIngredient(new Ingredient("finely grated orange zestr", new BigDecimal(1), tablespoon))
                .addIngredient(new Ingredient("fresh-squeezed orange juice", new BigDecimal(3), tablespoon))
                .addIngredient(new Ingredient("Olive Oil", new BigDecimal(2), tablespoon))
                .addIngredient(new Ingredient("boneless chicken thighs", new BigDecimal(4), tablespoon))
                .addIngredient(new Ingredient("small corn tortillasr", new BigDecimal(8), each))
                .addIngredient(new Ingredient("packed baby arugula", new BigDecimal(3), cup))
                .addIngredient(new Ingredient("medium ripe avocados, slic", new BigDecimal(2), each))
                .addIngredient(new Ingredient("radishes, thinly sliced", new BigDecimal(4), each))
                .addIngredient(new Ingredient("cherry tomatoes, halved", new BigDecimal(".5"), pint))
                .addIngredient(new Ingredient("red onion, thinly sliced", new BigDecimal(".25"), each))
                .addIngredient(new Ingredient("Roughly chopped cilantro", new BigDecimal(4), each))
                .addIngredient(new Ingredient("cup sour cream thinned with 1/4 cup milk", new BigDecimal(4), cup))
                .addIngredient(new Ingredient("lime, cut into wedges", new BigDecimal(4), each));

        tacosRecipe.getCategories().add(american);
        tacosRecipe.getCategories().add(mexican);

        tacosRecipe.setUrl("http://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/");
        tacosRecipe.setServings(4);
        tacosRecipe.setSource("Simply Recipes");

        recipes.add(tacosRecipe);

        return recipes;
    }

    private UnitOfMeasure getUnitOfMeasure(String description) {
        return unitOfMeasureRepository
                .findByDescription(description)
                .orElseThrow(() -> new RuntimeException("Expected UOM not found"));
    }

    private Category getCategory(String name) {
        return categoryRepository
                .findByName(name)
                .orElseThrow(() -> new RuntimeException("Expected UOM not found"));
    }
}
