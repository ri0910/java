package org.riya.JDBCJavaEx;

import java.util.ArrayList;
import java.util.List;

import org.riya.JDBCJavaEx.model.Student;
import org.riya.JDBCJavaEx.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class JdbcJavaExApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(JdbcJavaExApplication.class, args);
		Student s = context.getBean(Student.class);
		s.setRollNo(1);
		s.setName("Rohan");
		s.setMarks(90);
		System.out.print(s.toString());
		
		StudentService service = context.getBean(StudentService.class);
		service.addStudent(s);
		
		List<Student> students = service.getStudentList();
		System.out.println(students);
		
		
		
	}

}
