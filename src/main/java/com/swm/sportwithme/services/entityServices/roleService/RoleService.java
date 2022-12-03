package com.swm.sportwithme.services.entityServices.roleService;

import com.swm.sportwithme.models.Role;

public interface RoleService {
    void save(Long id, String name);
    Role getById(Long id);
}
