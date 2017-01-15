package com.shahinjo.thingy.shahinportfolio.Entities;

/**
 * Created by shahin on 1/13/17.
 */

public class ProjectEntity extends PortfolioGeneralClass {

    private String projectName;
    private String description;
    private String workLocation;
    private byte[] image;
    private String publicLink;
    private String sourceCodeLink;

    // Screen Shots or Images (List of Images)

    public ProjectEntity() {

    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWorkLocation() {
        return workLocation;
    }

    public void setWorkLocation(String workLocation) {
        this.workLocation = workLocation;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getPublicLink() {
        return publicLink;
    }

    public void setPublicLink(String publicLink) {
        this.publicLink = publicLink;
    }

    public String getSourceCodeLink() {
        return sourceCodeLink;
    }

    public void setSourceCodeLink(String sourceCodeLink) {
        this.sourceCodeLink = sourceCodeLink;
    }


}
