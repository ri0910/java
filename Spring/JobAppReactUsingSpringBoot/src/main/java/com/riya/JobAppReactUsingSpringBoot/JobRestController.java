package com.riya.JobAppReactUsingSpringBoot;


import com.riya.JobAppReactUsingSpringBoot.model.JobPost;
import com.riya.JobAppReactUsingSpringBoot.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobRestController {


    @Autowired
    private JobService service;


    @GetMapping("jobPosts")
    public List<JobPost> viewAllJobs(){
        return service.viewAllJobs();
    }

    @GetMapping("jobPost/{postId}")
    public JobPost getJob(@PathVariable("postId") int postId){
        return service.getJob(postId);
    }

    @PostMapping("jobPost")
    public JobPost addJob(@RequestBody JobPost jobpost){
        service.addjob(jobpost);
        return service.getJob(jobpost.getPostId());
    }

    @PutMapping("jobPost")
    public JobPost updateJobPost(@RequestBody JobPost jobPost){
        service.updateJobPost(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    @DeleteMapping("jobPost/{postId}")
    public String deleteJobPost(@PathVariable("postId") int jobid){
        service.deleteJobPost(jobid);
        return "Deleted";
    }

    @GetMapping("load")
    public String load(){
        service.load();
        return "success";
    }

    @GetMapping("jobPost/keyword/{keyword}")
    public List<JobPost> searchKeyword(@PathVariable("keyword") String keyword){
        return service.searchByKeyword(keyword);
    }

}
