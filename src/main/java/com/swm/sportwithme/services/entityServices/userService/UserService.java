package com.swm.sportwithme.services.entityServices.userService;

import com.swm.sportwithme.models.User;

public interface UserService {
    boolean save(User user);
    boolean save(User user, Long roleId);
    boolean update(User user, String username);
    User findByUsername(String username);
}
