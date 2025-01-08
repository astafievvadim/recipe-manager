package com.astafiev.recipemanager.repos;

import com.astafiev.recipemanager.model.User;

import org.antlr.v4.runtime.misc.MultiMap;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.Optional;



@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    //Optional<User> findUserById(Long id);
    Optional<User> findUserByUsername(String username);
    Optional<User> findUserByEmail(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
