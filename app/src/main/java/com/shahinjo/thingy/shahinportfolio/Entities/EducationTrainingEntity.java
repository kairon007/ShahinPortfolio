package com.shahinjo.thingy.shahinportfolio.Entities;

import java.util.Date;

/**
 * Created by shahin on 1/13/17.
 */

public class EducationTrainingEntity extends PortfolioGeneralClass {

    private Date from;
    private Date to;
    private String degree;
    private String department;
    private String institutionName;

    public EducationTrainingEntity() {

    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }
}
