package com.swm.sportwithme.utilities;

import com.swm.sportwithme.models.City;
import com.swm.sportwithme.models.User;
import com.swm.sportwithme.services.entityServices.cityService.CityServiceImplementation;
import com.swm.sportwithme.services.entityServices.countryService.CountryServiceImplementation;
import com.swm.sportwithme.services.entityServices.roleService.RoleServiceImplementation;
import com.swm.sportwithme.services.entityServices.userService.UserServiceImplementation;

public class TablesInit {
    public static void rolesTableInit(RoleServiceImplementation roleService) {
        if (roleService.getById(1L) == null){
            roleService.save(1L, "ROLE_ADMIN");
            roleService.save(2L, "ROLE_USER");
            roleService.save(3L, "ROLE_STRIKED");
        }
    }

    public static void countryTableInit(CountryServiceImplementation countryService){
        if(countryService.getById(1L) == null)
            countryService.save("Россия");
    }
    public static void cityTableInit(CityServiceImplementation cityService){
        if(cityService.getById(1L) == null){
            cityService.save("Москва", "Россия");
            cityService.save("Санкт-Петербург", "Россия");
            cityService.save("Новосибирск", "Россия");
            cityService.save("Екатеринбург", "Россия");
            cityService.save("Казань", "Россия");
            cityService.save("Нижний Новгород", "Россия");
            cityService.save("Челябинск", "Россия");
            cityService.save("Красноярск", "Россия");
            cityService.save("Самара", "Россия");
            cityService.save("Уфа", "Россия");
            cityService.save("Ростов на Дону", "Россия");
            cityService.save("Омск", "Россия");
            cityService.save("Краснодар", "Россия");
            cityService.save("Воронеж", "Россия");
            cityService.save("Пермь", "Россия");
            cityService.save("Волгоград", "Россия");
        }
    }


    public static void adminInit(UserServiceImplementation userServiceImplementation) {
        if (userServiceImplementation.findByUsername("admin") == null) {
            User user = new User("admin", "admin");
            userServiceImplementation.save(user, 1L);
        }
    }
}