package com.riya.springdatajpa;

import com.riya.springdatajpa.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class SpringDataJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringDataJpaApplication.class, args);

		StudentRepo repo = context.getBean(StudentRepo.class);

		Student s1 = context.getBean(Student.class);
		Student s2 = context.getBean(Student.class);
		Student s3 = context.getBean(Student.class);

		s1.setRollNo(1);
		s1.setName("Riya");
		s1.setMarks(99);

		s2.setRollNo(2);
		s2.setName("Aniket");
		s2.setMarks(100);

		s3.setRollNo(3);
		s3.setName("Raha");
		s3.setMarks(100);

//		repo.save(s1);
//		repo.save(s2);
//		repo.save(s3);

		System.out.println(repo.findAll());
		System.out.println(repo.findById(1));

        Optional<Student> s = repo.findById(111);
		System.out.println(s.orElse(new Student()));

		System.out.println(repo.findByName("Aniket"));
		System.out.println(repo.findByMarksGreaterThan(99));
		System.out.println(repo.findBySName("Riya"));
	}

}
