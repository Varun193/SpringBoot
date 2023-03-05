package com.joblisting.controller;

import com.joblisting.Dto.JobListingDto;
import com.joblisting.entites.JobListing;
import com.joblisting.repositories.JobListingRepository;
import com.joblisting.service.JobListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/jobListing")
public class JobListingController {

    @Autowired
    private JobListingService jobListingService;
    @Autowired
    private JobListingRepository jobListingRepository;

    @PutMapping
    public ResponseEntity<?> postJobListing(@RequestBody JobListingDto jobListingDto) throws URISyntaxException {
        int jobListingNo = 0;
         jobListingNo = jobListingService.postJobListing(jobListingDto);
        return ResponseEntity.created(new URI("/jobListing/"+jobListingNo)).build();
    }

    @PostMapping
    public ResponseEntity<?> saveJobListing(@RequestBody JobListingDto jobListingDto) {
        JobListing jobListing = jobListingService.saveJobDetails(jobListingDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping(produces = "application/json")
    public List<JobListingDto> getJobDetails(@RequestParam(value = "sortBy", required = false, defaultValue = "JobListingNo") String sortBy) {
        List<JobListingDto> jobListingDtos = null;
        jobListingRepository.findAll().forEach(System.out::println);
         jobListingDtos = jobListingService.getJobDetails(sortBy);
        return jobListingDtos;
    }

    @DeleteMapping(value = "/{jobListingNo}")
    public ResponseEntity<?> deleteJobDetail(@PathVariable int jobListingNo) {
//
//        System.out.println("/ndelete/n");
//        List<JobListing> collect1 = jobListingRepository.findAll().stream().filter(i -> i.getJobListingNo() == jobListingNo).collect(Collectors.toList());
//        System.out.println(collect1);
        jobListingService.deleteJobByid(jobListingNo);
        return ResponseEntity.status(200).build();
    }
}
