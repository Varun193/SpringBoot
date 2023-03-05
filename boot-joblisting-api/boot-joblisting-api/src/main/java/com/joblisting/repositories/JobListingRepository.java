package com.joblisting.repositories;

import com.joblisting.entites.JobListing;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobListingRepository extends JpaRepository<JobListing,Integer> {


    @Override
    public <S extends JobListing> S save(S entity);

    @Override
    public List<JobListing> findAll(Sort sort);

    @Override
    public <S extends JobListing> S saveAndFlush(S entity);

    void deleteById(Integer jobListingNo);
}
