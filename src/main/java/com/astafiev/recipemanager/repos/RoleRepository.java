package com.astafiev.recipemanager.repos;

import com.astafiev.recipemanager.model.ERole;
import com.astafiev.recipemanager.model.Role;
import com.astafiev.recipemanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
