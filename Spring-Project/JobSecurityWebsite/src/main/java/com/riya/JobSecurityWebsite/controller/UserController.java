package com.riya.JobSecurityWebsite.controller;


import com.riya.JobSecurityWebsite.model.AuthRequest;
import com.riya.JobSecurityWebsite.model.User;
import com.riya.JobSecurityWebsite.service.JwtService;
import com.riya.JobSecurityWebsite.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @GetMapping("/home")
    public String home(){
        return "Hello There!";
    }

    @PostMapping("/signup")
    public User addUser(@RequestBody User user){
        service.addUser(user);
        return service.getUser(user.getId());
    }

    @GetMapping("/users")
    public List<User> users(){
        return service.viewUsers();
    }

    @PostMapping("/signin")
    public String logIn(@RequestBody AuthRequest authRequest){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if(authentication.isAuthenticated()){
            return jwtService.generateToken(authRequest.getUsername());

        }else{
            throw new UsernameNotFoundException("Invalid user request!");
        }
    }

    @GetMapping("/getUsers/{id}")
    @PreAuthorize("hasAuthority('user')")
    public User getAllUsers(@PathVariable Integer id){
        return service.getUser(id);
    }


}
