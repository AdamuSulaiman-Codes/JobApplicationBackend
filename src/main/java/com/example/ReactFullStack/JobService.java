package com.example.ReactFullStack;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public void addJob(JobPost jobPost){
        jobRepository.addJob(jobPost);
    }

    public List<JobPost> getAllJobs(){
        return jobRepository.getAllJobs();
    }

    public JobPost getJob(int i){
        return jobRepository.getJob(i);
    }
    public void updateJob(JobPost jobPost){
        jobRepository.updateJob(jobPost);
    }

    public void deleteJob(int postId) {
        jobRepository.deleteJob(postId);
    }
}
