package com.riya.Ecomerce.service;


import com.riya.Ecomerce.model.User;
import com.riya.Ecomerce.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;


    private PasswordEncoder passwordEncoder;

//    @Autowired
//    private AuthenticationManager authenticationManager;

//    @Autowired
//    private JwtProvider jwtProvider;

    public void signup(User user){
        user.setFirstname(user.getFirstname());
        user.setLastname(user.getLastname());
        user.setEmail(user.getEmail());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setConfirmPassword(passwordEncoder.encode(user.getConfirmPassword()));
        user.setRole(user.getRole());
        userRepository.save(user);
    }

    public List<User> viewAllUsers() {
        return userRepository.findAll();
    }
}
