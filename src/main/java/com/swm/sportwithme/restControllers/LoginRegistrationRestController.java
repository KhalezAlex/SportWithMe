package com.swm.sportwithme.restControllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginRegistrationRestController {
//    private final CustomersService customersService;
//
//    public LoginRegistrationRestController(CustomersService customersService) {
//        this.customersService = customersService;
//    }
//
//    @PostMapping("/checkLoginForRegistration")
//    public String checkLogin(@RequestParam String login) {
//        return getJson(customersService.checkLogin(login));
//    }
//
//    @PostMapping("/checkPhoneForRegistration")
//    public String checkPhone(@RequestParam String phone) {
//        return getJson(customersService.checkPhone(phone));
//    }
//
//    private String getJson(Object resp) {
//        GsonBuilder builder = new GsonBuilder();
//        Gson response = builder.create();
//        return response.toJson(resp);
//    }
}
