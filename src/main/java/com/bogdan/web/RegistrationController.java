package com.bogdan.web;

import com.bogdan.domain.Role;
import com.bogdan.domain.User;
import com.bogdan.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/registration")
    public String registrationPage(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String registrationUserPage(Model model,
                                       @Validated @ModelAttribute("user") User user,
                                       BindingResult result) {
        User userFromDb = userRepo.findByUsername(user.getUsername());
        if (result.hasErrors()) {
            return "registration";
        }
        if (userFromDb != null) {
            model.addAttribute("message", "User with this name already exists!");
            return "registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);

        return "redirect:/login";
    }
}