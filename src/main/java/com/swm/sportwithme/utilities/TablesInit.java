package com.swm.sportwithme.utilities;

import com.swm.sportwithme.models.User;
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

    public static void adminInit(UserServiceImplementation userServiceImplementation) {
        if (userServiceImplementation.findByUsername("admin") == null) {
            User user = new User("admin", "admin");
            userServiceImplementation.save(user, 1L);
        }
    }
}