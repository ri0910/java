package com.riya.Ecomerce.controllers;

import com.riya.Ecomerce.model.User;
import com.riya.Ecomerce.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IndexController {

    @Autowired
    private AuthService authService;

    @GetMapping(value = {"/", "home"})
    public String Greet(HttpServletRequest request){
        return "Hello " + request.getSession().getId();
    }

    @GetMapping("users")
    public List<User> viewAllUsers(){
        return authService.viewAllUsers();
    }

    @PostMapping("signup")
    public ResponseEntity signup(@RequestBody User user){
        authService.signup(user);
        return new ResponseEntity(HttpStatus.OK);
    }

}
