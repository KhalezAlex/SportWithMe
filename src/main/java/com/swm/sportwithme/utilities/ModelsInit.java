package com.swm.sportwithme.utilities;

import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;

public class ModelsInit {
    public static void homePageModelInit(Model model, Authentication auth) {
        if (auth != null)
            authModelInit(model, auth);
        else
            nonAuthModelInit(model);
    }

    private static void authModelInit(Model model, Authentication auth) {
        model.addAttribute("isAuthenticated", true);
        model.addAttribute("buttonValue", auth.getName());
        String action = "/".concat(auth.getAuthorities().toArray()[0].toString().
                substring(5).toLowerCase()).concat("_page");
        model.addAttribute("action", action);
    }

    private static void nonAuthModelInit(Model model) {
        model.addAttribute("isAuthenticated", false);
        model.addAttribute("buttonValue", "Войти");
        model.addAttribute("action", "/log_reg_page");
    }
}

