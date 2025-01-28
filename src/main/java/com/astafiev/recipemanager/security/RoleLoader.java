
package com.astafiev.recipemanager.security;

import com.astafiev.recipemanager.model.ERole;
import com.astafiev.recipemanager.model.Role;
import com.astafiev.recipemanager.model.User;
import com.astafiev.recipemanager.repos.RoleRepository;
import com.astafiev.recipemanager.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

//@Component
public class RoleLoader{// implements ApplicationRunner {

    private UserRepository userRepository;

    @Autowired
    public RoleLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //@Override
    public void run(ApplicationArguments args) throws Exception {
        userRepository.save(new User("user","email","{noop}password"));
    }


}