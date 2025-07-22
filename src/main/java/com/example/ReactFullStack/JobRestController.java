package com.example.ReactFullStack;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobRestController {
    @Autowired
    private JobService jobService;

    @GetMapping("jobs")
    public List<JobPost> getAllJobs(){
        return jobService.getAllJobs();
    }   

    @GetMapping("job/{postId}")
    public JobPost getJobPost(@PathVariable("postId") int postId){
        return jobService.getJob(postId);
    }

    @PostMapping("job")
    public JobPost addJob(@RequestBody JobPost jobPost){
        jobService.addJob(jobPost);
        return jobService.getJob(jobPost.getPostId());
    }
    
    @PutMapping("job")
    public JobPost updateJob(@RequestBody JobPost jobPost){
        jobService.updateJob(jobPost);
        return jobService.getJob(jobPost.getPostId());
    }

    @DeleteMapping("job/{postId}")
    public String deleteJob(@PathVariable("postId") int postId){
        jobService.deleteJob(postId);
        return "Deleted";
    }
}
