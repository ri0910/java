package org.riya.JDBCJavaEx.service;

import java.util.List;

import org.riya.JDBCJavaEx.model.Student;
import org.riya.JDBCJavaEx.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentService {
	
	private StudentRepo repo;
	
	

	public StudentRepo getRepo() {
		return repo;
	}


	@Autowired
	public void setRepo(StudentRepo repo) {
		this.repo = repo;
	}



	public void addStudent(Student s) {
		
		repo.save(s);
		
	}


	public List<Student> getStudentList() {
		return repo.findAll();
	}

}
