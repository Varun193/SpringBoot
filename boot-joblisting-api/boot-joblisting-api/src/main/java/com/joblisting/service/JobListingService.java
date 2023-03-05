package com.joblisting.service;

import com.joblisting.Dto.JobListingDto;
import com.joblisting.entites.JobListing;
import com.joblisting.repositories.JobListingRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobListingService {

    @Autowired
    private JobListingRepository jobListingRepository;


    public int postJobListing(JobListingDto jobListingDto) {
        int jobListingNo = 0;

        JobListing jobListing = new JobListing();
        BeanUtils.copyProperties(jobListingDto, jobListing);
         jobListing = jobListingRepository.saveAndFlush(jobListing);

         jobListing.getJobListingNo();

        return jobListingNo;
    }

    public JobListing saveJobDetails(JobListingDto jobListingDto) {

        JobListing jobListing = new JobListing();
        BeanUtils.copyProperties(jobListingDto,jobListing);
        jobListing = jobListingRepository.save(jobListing);
        return jobListing;

    }

    public List<JobListingDto> getJobDetails(String sortColumn) {
      List<JobListingDto>jobListingDtos = null;
      List<JobListing>jobListing = null;
      jobListing = jobListingRepository.findAll(Sort.by(sortColumn));
      if (jobListing != null && jobListing.size() > 0) {
          jobListingDtos = jobListing.stream().map(jl -> {
              JobListingDto jobListingDto = new JobListingDto();
              BeanUtils.copyProperties(jl, jobListingDto);
              return jobListingDto;
          }).collect(Collectors.toList());
      }
      return jobListingDtos;
    }

    public void deleteJobByid(int jobListingNo) {
        jobListingRepository.deleteById(jobListingNo);
    }
}
