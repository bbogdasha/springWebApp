package com.bogdan.web;

import com.bogdan.domain.Recipe;
import com.bogdan.domain.User;
import com.bogdan.repo.RecipeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public String createRecipe(@AuthenticationPrincipal User user, @RequestParam String name,
                               @RequestParam String time, @RequestParam String ingredients,
                               @RequestParam String steps, @RequestParam int kcal,
                               @RequestParam int fat, @RequestParam int sugars,
                               @RequestParam String email) {
        Recipe recipe = new Recipe(name, time, ingredients, steps, kcal, fat, sugars, email, user);
        recipeRepo.save(recipe);
        return "redirect:/recipes";
    }

    // !!! Compact version without author !!!

//    @PostMapping("/createRecipe")
//    public String createRecipe(@ModelAttribute("recipe") Recipe recipe) {
//        recipeRepo.save(recipe);
//        return "redirect:/recipes";
//    }
}
