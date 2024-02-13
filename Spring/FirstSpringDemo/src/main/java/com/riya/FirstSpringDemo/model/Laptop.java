package com.riya.FirstSpringDemo.model;

import org.springframework.stereotype.Component;

@Component
//@Primary
public class Laptop implements Computer{

    public void compile(){
        System.out.println("Compiling using Laptop...");
    }
}
