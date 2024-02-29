package com.riya.SpringDataRestJavaEx.repo;



import com.riya.SpringDataRestJavaEx.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface JobRepo extends JpaRepository<JobPost, Integer> {


}
