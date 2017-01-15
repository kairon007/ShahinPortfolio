package com.shahinjo.thingy.shahinportfolio.Entities;

/**
 * Created by shahin on 1/13/17.
 */

public class HobbyInterestEntity extends PortfolioGeneralClass {

    private byte[] image;
    private String name;

    public HobbyInterestEntity() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
