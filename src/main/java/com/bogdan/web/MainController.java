package com.bogdan.web;

import com.bogdan.domain.Recipe;
import com.bogdan.repo.RecipeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private RecipeRepo recipeRepo;

    @GetMapping("/")
    public String greeting() {
        return "greeting";
    }

    @GetMapping("/recipes")
    public String recipes(Map<String, Object> model) {
        Iterable<Recipe> findAllRecipes = recipeRepo.findAllByOrderByIdAsc();
        model.put("recipes", findAllRecipes);
        return "recipes";
    }

    @GetMapping("/createRecipe")
    public String createRecipePage() {
        return "createRecipe";
    }

    @PostMapping("/createRecipe")
    public String createRecipe(@ModelAttribute("recipe") Recipe recipe) {
        recipeRepo.save(recipe);
        return "redirect:/recipes";
    }
}
