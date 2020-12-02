package com.bogdan.web;

import com.bogdan.model.Recipe;
import com.bogdan.model.User;
import com.bogdan.repo.RecipeRepo;
import com.bogdan.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.time.LocalTime;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Controller
public class RecipeController {

    @Autowired
    private RecipeRepo recipeRepo;
    @Autowired
    private UserRepo userRepo;

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
        }
        recipe.setTime(timeFormat);
        recipe.setAuthor(user);
        recipeRepo.save(recipe);
        return "redirect:/recipes";
    }

    @GetMapping("/recipe/{id}")
    public String recipePage(@PathVariable("id") Long id, Model model) {
        Optional<Recipe> optional = recipeRepo.findById(id);
        if (!optional.isPresent()) {
            throw new EntityNotFoundException("Recipe with id " + id + " not found");
        }
        model.addAttribute("recipe", recipeRepo.getRecipeById(id));
        return "recipePage";
    }

    @GetMapping("/recipe/delete/{id}")
    public String recipeDelete(@PathVariable("id") Long id) {
        Optional<Recipe> optional = recipeRepo.findById(id);
        if (!optional.isPresent()) {
            throw new EntityNotFoundException("Recipe with id " + id + " not found");
        }
        Recipe recipe = recipeRepo.getRecipeById(id);
        recipeRepo.delete(recipe);
        return "redirect:/recipes";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, @RequestParam String type, Map<String, Object> model) {
        if (type.equals("name")) {
            Iterable<Recipe> recipes;
            if (filter != null && !filter.isEmpty()) {
                recipes = recipeRepo.findByName(filter);
            } else {
                recipes = recipeRepo.findAllByOrderByIdAsc();
            }
            model.put("recipes", recipes);
        } else if (type.equals("username")) {
            Iterable<Recipe> recipes;
            if (filter != null && !filter.isEmpty()) {
                recipes = recipeRepo.findByAuthor(userRepo.findByUsername(filter));
            } else {
                recipes = recipeRepo.findAllByOrderByIdAsc();
            }
            model.put("recipes", recipes);
        }
        return "recipes";
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER') and principal.username == #name")
    @GetMapping("/recipesUser/{name}")
    public String recipesUser(@PathVariable("name") String name, Model model) {
        Optional<User> optional = userRepo.findById(userRepo.findByUsername(name).getId());
        if (!optional.isPresent()) {
            throw new EntityNotFoundException("User with name " + name + " not found");
        }
        model.addAttribute("recipes", recipeRepo.findByAuthor(userRepo.findByUsername(name)));
        model.addAttribute("user", userRepo.findByUsername(name));
        return "userPage";
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER') and principal.username == #name")
    @GetMapping("/recipesUser/{name}/delete/{id}")
    public String recipeDeleteUserPage(@PathVariable("id") Long id, @PathVariable("name") String name) {
        Optional<User> optionalUser = userRepo.findById(userRepo.findByUsername(name).getId());
        if (!optionalUser.isPresent()) {
            throw new EntityNotFoundException("User with name " + name + " not found");
        }
        Optional<Recipe> optionalRecipe = recipeRepo.findById(id);
        if (!optionalRecipe.isPresent()) {
            throw new EntityNotFoundException("Recipe with id " + id + " not found");
        }
        Recipe recipe = recipeRepo.getRecipeById(id);
        recipeRepo.delete(recipe);
        return "redirect:/recipesUser/" + name;
    }
}
