package com.swm.sportwithme.controllers;

import com.swm.sportwithme.services.roleService.RoleServiceImplementation;
import com.swm.sportwithme.services.userService.UserServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import static com.swm.sportwithme.utilities.ModelsInit.homePageModelInit;
import static com.swm.sportwithme.utilities.TablesInit.adminInit;
import static com.swm.sportwithme.utilities.TablesInit.rolesTableInit;


@Controller
public class HomePageController {
    @Autowired
    RoleServiceImplementation roleService;
    @Autowired
    UserServiceImplementation userServiceImplementation;

    @GetMapping("/")
    public String homePage(Authentication auth, Model model) {
        rolesTableInit(roleService);
        adminInit(userServiceImplementation);
        homePageModelInit(model, auth);
        return "home_page";
    }

    @GetMapping("/log_reg_page")
    public String login(Model model, Authentication auth){
        if (auth != null) {
            homePageModelInit(model, auth);
            return "home_page";
        }
        return "log_reg_page";
    }

    @GetMapping("/admin_page")
    public String admin_page() {
        return "admin_page";
    }

    @GetMapping("/user_page")
    public String user_page() {
        return "user_page";
    }
}
