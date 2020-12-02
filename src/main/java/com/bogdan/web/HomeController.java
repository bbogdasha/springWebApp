package com.bogdan.web;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping({"/", "/greeting"})
    public String greeting() {
        return "greeting";
    }

    @GetMapping("/accessDenied")
    public ModelAndView accessDenied() {
        throw new AccessDeniedException("You don't have permission to access this page!");
    }
}
