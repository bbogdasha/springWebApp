package com.bogdan.web;

import com.bogdan.domain.Recipe;
import com.bogdan.domain.User;
import com.bogdan.repo.RecipeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Controller
public class MainController {

    @Autowired
    private RecipeRepo recipeRepo;

    @Value("${upload.path}")
    private String uploadPath;

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
                               @RequestParam String email, @RequestParam("file")MultipartFile file
    ) throws IOException {
        Recipe recipe = new Recipe(name, time, ingredients, steps, kcal, fat, sugars, email, user);

        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadFile = new File(uploadPath);

            if (!uploadFile.exists()) {
                uploadFile.mkdir();
            }

            String uuidNameFile = UUID.randomUUID().toString();
            String fullNameFile = uuidNameFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + fullNameFile));

            recipe.setFilename(fullNameFile);
        }

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
