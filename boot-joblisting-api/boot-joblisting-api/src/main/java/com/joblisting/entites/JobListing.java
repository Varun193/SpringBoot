package com.joblisting.entites;



import javax.persistence.*;

@Entity
@Table(name = "job_listing")
public class JobListing {

    @Id
    @Column(name = "job_listing_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int jobListingNo;
    protected String title;
    protected String company;
    protected int experience;
    protected String designation;
    @Column(name = "package_offered")
    protected double packageOffered;

    public int getJobListingNo() {
        return jobListingNo;
    }

    public void setJobListingNo(int jobListingNo) {
        this.jobListingNo = jobListingNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getPackageOffered() {
        return packageOffered;
    }

    public void setPackageOffered(double packageOffered) {
        this.packageOffered = packageOffered;
    }
}
