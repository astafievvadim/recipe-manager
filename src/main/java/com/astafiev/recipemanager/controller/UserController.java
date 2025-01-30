package com.astafiev.recipemanager.controller;
import com.astafiev.recipemanager.exception.CredentialsException;
import com.astafiev.recipemanager.model.User;
import com.astafiev.recipemanager.payload.request.SignInRequest;
import com.astafiev.recipemanager.payload.request.SignUpRequest;
import com.astafiev.recipemanager.repository.UserRepository;
import com.astafiev.recipemanager.service.UserService;
import com.nimbusds.jose.proc.SecurityContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    private PasswordEncoder passwordEncoder;

    private UserRepository userRepository;
    private AuthenticationManager authenticationManager;
/*
    @Autowired
    public UserController(UserService userService, UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }
*/
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }
    //@TODO: It's sorta bad practice. It could be used with malice, so I should come back and redo the err messages. Good for now

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody SignUpRequest signUpRequest){

        if(userRepository.existsByUsername(signUpRequest.getUsername())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new CredentialsException("Credentials are taken"));
        }
        if(userRepository.existsByEmail(signUpRequest.getUsername())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new CredentialsException("Credentials are taken"));
        }
        if(!signUpRequest.isValid()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new CredentialsException("Passwords mismatch"));
        }

        User user = new User();

        user.setUsername(signUpRequest.getUsername());
        user.setPassword(
                passwordEncoder.encode(signUpRequest.getPassword())
        );
        user.setEmail(signUpRequest.getEmail());

        userRepository.save(user);

        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signIn(@RequestBody SignInRequest signInRequest){

        Authentication auth = null;

        try{
            auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInRequest.getUsername(), signInRequest.getPassword()));
        } catch (BadCredentialsException e){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        SecurityContextHolder.getContext().setAuthentication(auth);
        return ResponseEntity.ok("Signed in successfully");
    }

    @PostMapping("/signout")
    public String signOut(){
        return "it works";
    }

    @GetMapping("/permitted")
    public String allAccess() {
        return "private Content.";
    }

}
