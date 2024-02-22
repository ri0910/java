package com.riya.JobAppUsingSpring.service;

import com.riya.JobAppUsingSpring.model.JobPost;
import com.riya.JobAppUsingSpring.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepo repo;

    public void addjob(JobPost jobPost){
        repo.addjob(jobPost);
    }


    public List<JobPost> viewAllJobs(){
        return repo.viewAllJobs();
    }

}
