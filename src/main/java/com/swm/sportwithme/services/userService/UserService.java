package com.swm.sportwithme.services.userService;

import com.swm.sportwithme.models.User;

public interface UserService {
    void save(User user);
    void save(User user, Long roleId);
    User findByUserName(String username);
}
