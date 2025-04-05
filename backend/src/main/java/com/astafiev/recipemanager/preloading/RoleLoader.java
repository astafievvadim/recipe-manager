
package com.astafiev.recipemanager.preloading;

import com.astafiev.recipemanager.model.User;
import com.astafiev.recipemanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;

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