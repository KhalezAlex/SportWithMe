package com.swm.sportwithme.dao;

import com.swm.sportwithme.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDAO extends JpaRepository<Role, Long> {
}
