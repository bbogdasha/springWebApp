package com.bogdan.web;

import com.bogdan.model.Role;
import com.bogdan.model.User;
import com.bogdan.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/user")
    public String userList(Model model) {
        model.addAttribute("users", userRepo.findAllByOrderByIdAsc());
        return "userList";
    }

    @GetMapping("/user/{id}")
    public String userEdit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userRepo.getUserById(id));
        model.addAttribute("roles", Role.values());
        return "userEdit";
    }

    @PostMapping("/user/{id}")
    public String userEditSave(@PathVariable Long id, @RequestParam Map<String, String> form,
                               @ModelAttribute("user") User user) {
        User upUser = userRepo.getUserById(id);
        upUser.setUsername(user.getUsername());

        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());

        upUser.getRoles().clear();

        for (String key : form.keySet()) {
            if (roles.contains(key)) {
                upUser.getRoles().add(Role.valueOf(key));
            }
        }
        userRepo.save(upUser);
        return "redirect:/user";
    }

    @GetMapping("/user/{id}/delete")
    public String delete(@PathVariable("id") long id) {
        User user = userRepo.getUserById(id);
        userRepo.delete(user);
        return "redirect:/user";
    }
}
