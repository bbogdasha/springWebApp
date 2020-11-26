package com.bogdan.web;

import com.bogdan.model.Recipe;
import com.bogdan.model.User;
import com.bogdan.repo.RecipeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Map;
import java.util.UUID;

@Controller
public class RecipeController {

    @Autowired
    private RecipeRepo recipeRepo;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/recipes")
    public String recipes(Map<String, Object> model) {
        Iterable<Recipe> findAllRecipes = recipeRepo.findAllByOrderByIdAsc();
        model.put("recipes", findAllRecipes);
        return "recipes";
    }

    @GetMapping("/createRecipe")
    public String createRecipePage(Model model) {
        model.addAttribute("recipe", new Recipe());
        return "createRecipe";
    }

    @PostMapping("/createRecipe")
    public String createRecipe(Model model, @AuthenticationPrincipal User user,
                               @RequestParam String time,
                               @RequestParam("file") MultipartFile file,
                               @Validated @ModelAttribute("recipe") Recipe recipe,
                               BindingResult result) throws IOException {
        if (result.hasErrors()) {
            return "createRecipe";
        }
        LocalTime timeFormat = LocalTime.parse(time);
        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadFile = new File(uploadPath);

            if (!uploadFile.exists()) {
                uploadFile.mkdir();
            }

            String uuidNameFile = UUID.randomUUID().toString();
            String fullNameFile = uuidNameFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + fullNameFile));
            recipe.setFilename(fullNameFile);
            recipe.setTime(timeFormat);
            recipe.setAuthor(user);
        }
        recipeRepo.save(recipe);
        return "redirect:/recipes";
    }
}
