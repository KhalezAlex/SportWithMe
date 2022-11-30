package com.swm.sportwithme.services.userService;

import com.swm.sportwithme.dao.RoleDAO;
import com.swm.sportwithme.dao.UserDAO;
import com.swm.sportwithme.models.Role;
import com.swm.sportwithme.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImplementation implements UserService {
    @Autowired
    UserDAO userDAO;
    @Autowired
    RoleDAO roleDAO;

    @Autowired
    BCryptPasswordEncoder encoder;

    @Override
    @Transactional
    public void save(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleDAO.getOne(2L));
        user.setRoles(roles);
        userDAO.save(user);
    }

    @Override
    public void save(User user, Long roleId) {
        user.setPassword(encoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleDAO.getOne(roleId));
        user.setRoles(roles);
        userDAO.save(user);
    }

    @Override
    public User findByUserName(String username) {
        return userDAO.findByUsername(username);
    }
}
