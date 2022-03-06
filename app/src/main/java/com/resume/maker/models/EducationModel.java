package com.resume.maker.models;

public class EducationModel {
    String classType, passingYear, percentage, id;

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public String getPassingYear() {
        return passingYear;
    }

    public void setPassingYear(String passingYear) {
        this.passingYear = passingYear;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    public EducationModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EducationModel(String id, String classType, String passingYear, String percentage) {
        this.classType = classType;
        this.passingYear = passingYear;
        this.id  = id;
        this.percentage = percentage;
    }
}
