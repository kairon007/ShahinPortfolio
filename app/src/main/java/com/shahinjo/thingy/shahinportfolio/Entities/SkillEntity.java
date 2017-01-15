package com.shahinjo.thingy.shahinportfolio.Entities;

/**
 * Created by shahin on 1/13/17.
 */

public class SkillEntity extends PortfolioGeneralClass {

    private String name;
    private int strength;

    public SkillEntity() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }
}
