package com.riya.Springsecex.controller;


import com.riya.Springsecex.model.User;
import com.riya.Springsecex.service.USerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private USerService userService;

    @PostMapping("register")
    public User addUser(@RequestBody User user){
        return userService.saveUser(user);
    }
}
