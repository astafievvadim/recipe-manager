package com.astafiev.recipemanager.scrap;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
/*
public class CustomAuthenticationManager implements AuthenticationManager {

    private final UserService userService;

    public LocalAuthenticationManager(UserService personService) {
        this.userService = personService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) {
        String username = authentication.getName();
        if (!StringUtils.hasText(username)) {
            throw new BadCredentialsException("Username is empty");
        }
        Set<GrantedAuthority> mappedAuthorities = new HashSet<>();
        mappedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        User user = userService.findByUid(username); // This method saves the username if not found
        if (user.isAdmin()) {
            mappedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }
        return new UsernamePasswordAuthenticationToken(username, "", mappedAuthorities);
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        return null;
    }
}
}
*/