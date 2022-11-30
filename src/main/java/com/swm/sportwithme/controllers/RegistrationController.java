package com.swm.sportwithme.controllers;

import com.swm.sportwithme.models.User;
import com.swm.sportwithme.services.securityService.SecurityServiceImplementation;
import com.swm.sportwithme.services.userService.UserServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import static com.swm.sportwithme.utilities.ModelsInit.homePageModelInit;

@Controller
public class RegistrationController {
    @Autowired
    UserServiceImplementation userServiceImplementation;
    @Autowired
    SecurityServiceImplementation securityServiceImplementation;

//разобраться, почему не автологинит сразу после регистрации
    @PostMapping("/register")
    public String register(@ModelAttribute User user, Model model, Authentication auth) {
        userServiceImplementation.save(user);
        homePageModelInit(model, auth);
        return "home_page";
    }
}


//    @PostMapping("/login")
//    public String login(@ModelAttribute User user, Model model, Authentication auth) {
//        System.out.println("before" + auth);
//        securityServiceImplementation.login(user.getUsername(), user.getPassword());
//        System.out.println("after" + auth);
//        homePageModelInit(model, auth);
//        return "home_page";
//    }