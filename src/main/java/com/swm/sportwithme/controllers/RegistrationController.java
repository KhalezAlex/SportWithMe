package com.swm.sportwithme.controllers;

import com.swm.sportwithme.model.User;
import com.swm.sportwithme.services.securityService.SecurityServiceImplementation;
import com.swm.sportwithme.services.entityServices.userService.UserServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RegistrationController {
    @Autowired
    UserServiceImplementation userServiceImplementation;
    @Autowired
    SecurityServiceImplementation securityServiceImplementation;

//разобраться, почему не автологинит сразу после регистрации
    @PostMapping("/register")
    public String register(@ModelAttribute User user, Model model, RedirectAttributes attr) throws InterruptedException {
        if (userServiceImplementation.save(user))
            return "redirect:/";
        else {
            model.addAttribute("error", "true");
            return "log_reg_page";
        }
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user) {
        securityServiceImplementation.login(user.getUsername(), user.getPassword());
        return "redirect:/";
    }
}


