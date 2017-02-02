package com.shahinjo.thingy.shahinportfolio.Entities.GSONSchemes;

/**
 * Created by y.shahin on 2/2/2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ContactingList {

    @SerializedName("pi_id")
    @Expose
    private String piId;
    @SerializedName("ct_id")
    @Expose
    private String ctId;
    @SerializedName("pci_value")
    @Expose
    private String pciValue;
    @SerializedName("pci_link")
    @Expose
    private String pciLink;
    @SerializedName("ct_name")
    @Expose
    private String ctName;
    @SerializedName("ct_icon")
    @Expose
    private String ctIcon;

    public String getPiId() {
        return piId;
    }

    public void setPiId(String piId) {
        this.piId = piId;
    }

    public String getCtId() {
        return ctId;
    }

    public void setCtId(String ctId) {
        this.ctId = ctId;
    }

    public String getPciValue() {
        return pciValue;
    }

    public void setPciValue(String pciValue) {
        this.pciValue = pciValue;
    }

    public String getPciLink() {
        return pciLink;
    }

    public void setPciLink(String pciLink) {
        this.pciLink = pciLink;
    }

    public String getCtName() {
        return ctName;
    }

    public void setCtName(String ctName) {
        this.ctName = ctName;
    }

    public String getCtIcon() {
        return ctIcon;
    }

    public void setCtIcon(String ctIcon) {
        this.ctIcon = ctIcon;
    }

}