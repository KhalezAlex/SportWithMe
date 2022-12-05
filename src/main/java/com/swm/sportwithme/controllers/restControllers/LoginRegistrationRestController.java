package com.swm.sportwithme.controllers.restControllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.swm.sportwithme.services.entityServices.userService.UserServiceImplementation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginRegistrationRestController {
    private final UserServiceImplementation userService;

    public LoginRegistrationRestController(UserServiceImplementation userService) {
        this.userService = userService;
    }

    @PostMapping("/checkLoginForRegistration")
    public String checkLogin(@RequestParam String login) {
        return getJson(userService.checkLogin(login));
    }

    private String getJson(Object resp) {
        GsonBuilder builder = new GsonBuilder();
        Gson response = builder.create();
        return response.toJson(resp);
    }
}
