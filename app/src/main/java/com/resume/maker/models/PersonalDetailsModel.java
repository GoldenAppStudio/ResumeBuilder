package com.resume.maker.models;

public class PersonalDetailsModel {
    private String name;
    private String phoneNo;
    private String email;
    private String address;
    private String jobTitle;
    private String id;

    public PersonalDetailsModel(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PersonalDetailsModel(String id, String name, String phoneNo, String email, String address, String jobTitle) {
        this.name = name;
        this.phoneNo = phoneNo;
        this.email = email;
        this.address = address;
        this.jobTitle = jobTitle;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
}
