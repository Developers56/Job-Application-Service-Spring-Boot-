package com.learning.jobappservice.job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/jobs") //this annot will define a base url of all type of requests
public class jobController {

    JobService jobService;

    public jobController(JobService jobService) {
        this.jobService = jobService;
    }

    @RequestMapping
    public ResponseEntity<List<job>> findAll(){
        return new ResponseEntity<>(jobService.findAll(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody job job){
        jobService.createJob(job);
        return new ResponseEntity<>("job added successfully",HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<job> getJobById(@PathVariable Long id){
        job job = jobService.getjob(id);
        if (job != null)
            return new ResponseEntity<>(job, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable Long id){
        boolean deleted = jobService.deleteJobById(id);
        if (deleted)
        return new ResponseEntity<>("Job Deleted Successfully",HttpStatus.OK);
        else
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateById(@PathVariable Long id, @RequestBody job updatedJob){
        boolean updated = jobService.updateJob(id,updatedJob);
        if (updated)
            return new ResponseEntity<>("Job Updated Successfully",HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
