package com.swm.sportwithme.controllers;

import com.swm.sportwithme.models.User;
import com.swm.sportwithme.services.securityService.SecurityServiceImplementation;
import com.swm.sportwithme.services.entityServices.userService.UserServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    @Autowired
    UserServiceImplementation userServiceImplementation;
    @Autowired
    SecurityServiceImplementation securityServiceImplementation;

//разобраться, почему не автологинит сразу после регистрации
    @PostMapping("/register")
    public String register(@ModelAttribute User user) {
        userServiceImplementation.save(user);
        securityServiceImplementation.login(user.getUsername(), user.getPassword());
        return "redirect:/";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user) {
        System.out.println("до");
        securityServiceImplementation.login(user.getUsername(), user.getPassword());
        System.out.println("после");
        return "redirect:/";
    }
}


