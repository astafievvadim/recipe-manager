package com.astafiev.recipemanager.repository;

import com.astafiev.recipemanager.model.ERole;
import com.astafiev.recipemanager.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
