package com.resume.maker.models;

public class ExperienceModel {
    private String jobTitle;
    private String companyName;
    private String jobStartDate;
    private String jobEndDate;
    private String jobDescription;
    private String id;

    public ExperienceModel(){}

    public String getJobStartDate() {
        return jobStartDate;
    }

    public void setJobStartDate(String jobStartDate) {
        this.jobStartDate = jobStartDate;
    }

    public String getJobEndDate() {
        return jobEndDate;
    }

    public void setJobEndDate(String jobEndDate) {
        this.jobEndDate = jobEndDate;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ExperienceModel(String id, String jobTitle, String companyName, String jobStartDate, String jobEndDate, String jobDescription) {
        this.jobTitle = jobTitle;
        this.id = id;
        this.companyName = companyName;
        this.jobStartDate = jobStartDate;
        this.jobEndDate = jobEndDate;
        this.jobDescription = jobDescription;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }
}
