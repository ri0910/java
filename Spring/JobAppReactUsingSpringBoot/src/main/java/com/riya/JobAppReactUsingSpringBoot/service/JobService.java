package com.riya.JobAppReactUsingSpringBoot.service;

import com.riya.JobAppReactUsingSpringBoot.model.JobPost;
import com.riya.JobAppReactUsingSpringBoot.repo.JobRepo;
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

    public JobPost getJob(int postId) {
        return repo.getJob(postId);
    }

    public void updateJobPost(JobPost jobPost) {
        repo.updateJobPost(jobPost);
    }

    public void deleteJobPost(int jobPost) {
        repo.deleteJobPost(jobPost);
    }
}
