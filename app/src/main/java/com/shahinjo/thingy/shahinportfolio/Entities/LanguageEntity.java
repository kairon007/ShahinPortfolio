package com.shahinjo.thingy.shahinportfolio.Entities;

/**
 * Created by shahin on 1/13/17.
 */

public class LanguageEntity extends PortfolioGeneralClass {

    private String name;
    private String description;
    private double strength;

    public LanguageEntity() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getStrength() {
        return strength;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }
}
