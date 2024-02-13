package com.riya.FirstSpringDemo.repo;

import org.springframework.stereotype.Repository;

import com.riya.FirstSpringDemo.model.Laptop;

@Repository
public class LaptopRepository {
	
	public void save(Laptop lap) {
		System.out.println("Saved in databases successfully!");
	}

}
