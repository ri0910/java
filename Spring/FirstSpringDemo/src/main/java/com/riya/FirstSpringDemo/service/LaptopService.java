package com.riya.FirstSpringDemo.service;

import com.riya.FirstSpringDemo.model.Laptop;
import com.riya.FirstSpringDemo.repo.LaptopRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaptopService {
	
	@Autowired
	private LaptopRepository repo;

    public void addLaptopService(Laptop lap){
        repo.save(lap);
    }

    public boolean isGoodForProg(Laptop lap){
        return true;
    }
}
