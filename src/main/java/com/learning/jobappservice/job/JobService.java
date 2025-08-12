package com.learning.jobappservice.job;

import org.springframework.stereotype.Service;

import java.util.List;

public interface JobService {

    List<job> findAll();
    void createJob(job job);

    job getjob(Long id);

    boolean deleteJobById(Long id);

    boolean updateJob(Long id,job job);
}
