package com.riya.FirstSpringDemo;

import com.riya.FirstSpringDemo.model.Laptop;
import com.riya.FirstSpringDemo.service.LaptopService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FirstSpringDemoApplication {

	public static void main(String[] args) {
		// Any object created or managed by spring called beans.

		ApplicationContext context = SpringApplication.run(FirstSpringDemoApplication.class, args);
		System.out.println("Hello World");

		LaptopService service = context.getBean(LaptopService.class);

		Laptop lap = context.getBean(Laptop.class);

		service.addLaptopService(lap);

//		Code c = context.getBean(Code.class);
//		c.code();
	}

}
