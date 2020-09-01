package com.bogdan.web;

import com.bogdan.repo.RecipeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    private RecipeRepo recipeRepo;

    @GetMapping
    public String greeting() {
        return "greeting";
    }
}
