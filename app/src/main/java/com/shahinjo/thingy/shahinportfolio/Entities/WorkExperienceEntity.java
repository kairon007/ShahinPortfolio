package com.shahinjo.thingy.shahinportfolio.Entities;

import java.util.Date;

/**
 * Created by shahin on 1/13/17.
 */

public class WorkExperienceEntity extends PortfolioGeneralClass {

    private int yearsCount;
    private Date from;
    private Date to;
    private String position;
    private String company;

    public WorkExperienceEntity() {

    }

    public int getYearsCount() {
        return yearsCount;
    }

    public void setYearsCount(int yearsCount) {
        this.yearsCount = yearsCount;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
