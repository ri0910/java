package com.riya.JobSecurityWebsite.repository;


import com.riya.JobSecurityWebsite.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    User findById(int id);

    User findByUsername(String username);
}
