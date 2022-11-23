package com.swm.sportwithme.controllers;


import com.swm.sportwithme.models.CustomersModel;
import com.swm.sportwithme.models.LogPassModel;
import com.swm.sportwithme.services.CustomersService;
import com.swm.sportwithme.services.LogPassRegService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LogPassRegController {

    private final LogPassRegService logPassRegService;
    private final CustomersService customersService;

    public LogPassRegController(LogPassRegService logPassRegService, CustomersService customersService) {
        this.logPassRegService = logPassRegService;
        this.customersService = customersService;
    }

    @GetMapping("/")
    public String enterHomePage(Authentication auth, Model model) {
        if (auth != null)
            model.addAttribute("isAuthenticated", true);
        else
            model.addAttribute("isAuthenticated", false);
        return "index";
    }

//    @GetMapping("/login")
//    public String getLoginPage(Model model) {
//        model.addAttribute("loginRequest", new LogPassModel());
//        return "index";
//    }

    @PostMapping("/register")
    public String register(Authentication auth, Model model, @ModelAttribute LogPassModel logPassModel, @ModelAttribute CustomersModel customersModel) {
        System.out.println(logPassModel);
        System.out.println(customersModel);
        CustomersModel registeredCustomer = customersService.registerCustomer(customersModel.getLogin(),
                customersModel.getPhoneNumber());
        logPassRegService.registerUser(logPassModel.getLogPassHash(), logPassModel.getPhonePassHash(),
                getCustomerByRequestData(customersModel));
        model.addAttribute("isAuthenticated", false);
        return "index";
//        return registeredCustomer == null ? "error_page" : "index";
    }

    private CustomersModel getCustomerByRequestData(CustomersModel customersModel) {
        if (customersModel.getLogin() != null)
            return customersService.findCustomerByLogin(customersModel.getLogin());
        else
            return customersService.findCustomerByPhone(customersModel.getPhoneNumber());
    }


//    @PostMapping("/login")
//    public String login(@ModelAttribute LogPassModel logPassModel, Model model) {
//        System.out.println("login request: " + logPassModel);
//        LogPassModel authenticated =
//                logPassService.authenticate(logPassModel.getLogPassHash(), true);
//
//        if (authenticated != null) {
//            model.addAttribute("userLogin", authenticated.getLogin());
//            return "personal_page";
//        }
//        else return "error_page";
//    }
}
