package com.riya.springdatajpa;

import com.riya.springdatajpa.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

    List<Student> findByName(String name);
    List<Student> findByMarksGreaterThan(int num);


    @Query("Select s from Student s where s.name = ?1")
    List<Student> findBySName(String name);
}
