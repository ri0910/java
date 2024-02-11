package com.riya.FirstSpringDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Code {

    @Autowired
    Laptop laptop;
    public void code(){
        System.out.println("Coding...");
        laptop.compile();
    }
}
