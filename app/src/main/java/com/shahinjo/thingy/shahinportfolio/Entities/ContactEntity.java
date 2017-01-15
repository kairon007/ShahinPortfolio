package com.shahinjo.thingy.shahinportfolio.Entities;

/**
 * Created by shahin on 1/13/17.
 */

public class ContactEntity extends PortfolioGeneralClass {

    //Image

    private byte[] icon;
    private String name;
    private String link;

    public ContactEntity() {

    }

    public byte[] getIcon() {
        return icon;
    }

    public void setIcon(byte[] icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
