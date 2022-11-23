package com.swm.sportwithme.controllers.viewControllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
    @GetMapping("/")
    public String enterHomePage(Authentication auth, Model model) {
        System.out.println("запрос получен");
        System.out.println(auth);
        if (auth != null)
            model.addAttribute("isAuthenticated", true);
        else
            model.addAttribute("isAuthenticated", false);
        return "index";
    }
}
