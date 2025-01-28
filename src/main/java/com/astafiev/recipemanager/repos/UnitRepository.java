package com.astafiev.recipemanager.repos;

import com.astafiev.recipemanager.model.Role;
import com.astafiev.recipemanager.model.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UnitRepository extends JpaRepository<Unit, Long> {

    Optional<Unit> getUnitById(Long Id);

}
