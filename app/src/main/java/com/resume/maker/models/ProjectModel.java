package com.resume.maker.models;

public class ProjectModel {
    private String projectName;
    private String yourRole;
    private String teamSize;
    private String techUsed;
    private String projectSummary;
    private String id;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ProjectModel(String id, String projectName, String yourRole, String teamSize, String techUsed, String projectSummary) {
        this.projectName = projectName;
        this.yourRole = yourRole;
        this.teamSize = teamSize;
        this.techUsed = techUsed;
        this.projectSummary = projectSummary;
        this.id = id;
    }

    public String getYourRole() {
        return yourRole;
    }

    public void setYourRole(String yourRole) {
        this.yourRole = yourRole;
    }

    public String getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(String teamSize) {
        this.teamSize = teamSize;
    }

    public String getTechUsed() {
        return techUsed;
    }

    public void setTechUsed(String techUsed) {
        this.techUsed = techUsed;
    }

    public String getProjectSummary() {
        return projectSummary;
    }

    public void setProjectSummary(String projectSummary) {
        this.projectSummary = projectSummary;
    }

    public ProjectModel() {
    }
}
