package com.learning.jobappservice.job.impl;

import com.learning.jobappservice.job.JobRepository;
import com.learning.jobappservice.job.JobService;
import com.learning.jobappservice.job.job;
import jakarta.transaction.Transactional;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class JobServiceImpl implements JobService {

//    private List<job> jobs = new ArrayList<>();
    JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(job job) {
        try {
            jobRepository.save(job);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public job getjob(Long id) {
/*        for (job job:jobs){
            Long idd = job.getId();
            if (idd.equals(id)){
                return job;
            }
        }
        return null;*/
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJobById(Long id) {
        /*Iterator<job> iterator = jobs.iterator();
        while (iterator.hasNext()){
            job job = iterator.next();
            Long deletedId = job.getId();
            if (deletedId.equals(id)){
                iterator.remove();
            return true;
            }
        }*/
        try {
            jobRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean updateJob(Long id, job updatedJob) {
        /*for (job previousJob: jobs){
            Long idd = previousJob.getId();
            if (idd.equals(id)){
                previousJob.setTitle(updatedJob.getTitle());
                previousJob.setDescription(updatedJob.getDescription());
                previousJob.setMinSalary(updatedJob.getMinSalary());
                previousJob.setMaxSalary(updatedJob.getMaxSalary());
                previousJob.setLocation(updatedJob.getLocation());
                return true;
            }
        }
        return false;*/
        Optional<job> jobOptional = jobRepository.findById(id);
        if (jobOptional.isPresent()){
            job previousJob = jobOptional.get();
            previousJob.setTitle(updatedJob.getTitle());
            previousJob.setDescription(updatedJob.getDescription());
            previousJob.setMinSalary(updatedJob.getMinSalary());
            previousJob.setMaxSalary(updatedJob.getMaxSalary());
            previousJob.setLocation(updatedJob.getLocation());
            jobRepository.save(previousJob);
            return true;
        }

        return false;
    }


}
