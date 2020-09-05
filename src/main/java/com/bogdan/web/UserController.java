package com.bogdan.web;

import com.bogdan.domain.Role;
import com.bogdan.domain.User;
import com.bogdan.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
        return "userRoleList";
    }

    @GetMapping("/user/{id}")
    public String userEdit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userRepo.getUserById(id));
        model.addAttribute("roles", Role.values());
        return "userEditPage";
    }

    @PostMapping("/user")
    public String userEditSave(@RequestParam String username,
                               @RequestParam("userId") User user,
                               @RequestParam Map<String, String> form) {
        user.setUsername(username);

        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());

        user.getRoles().clear();

        for (String key : form.keySet()) {
            if (roles.contains(key)) {
                user.getRoles().add(Role.valueOf(key));
            }
        }

        userRepo.save(user);
        return "redirect:/user";
    }
}
