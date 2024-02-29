package com.riya.UserManagement.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("signin")
    public String login(){
        return "login";
    }

    @GetMapping("signup")
    public String register(){
        return "register";
    }
}
