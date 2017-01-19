
package com.shahinjo.thingy.shahinportfolio.Entities.GSONSchemes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class LanguageScheme implements Serializable {

    @SerializedName("l_id")
    @Expose
    private String lId;
    @SerializedName("l_name")
    @Expose
    private String lName;
    @SerializedName("l_description")
    @Expose
    private String lDescription;
    @SerializedName("l_strength")
    @Expose
    private String lStrength;
    @SerializedName("pi_id")
    @Expose
    private String piId;

    public String getLId() {
        return lId;
    }

    public void setLId(String lId) {
        this.lId = lId;
    }

    public String getLName() {
        return lName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }

    public String getLDescription() {
        return lDescription;
    }

    public void setLDescription(String lDescription) {
        this.lDescription = lDescription;
    }

    public String getLStrength() {
        return lStrength;
    }

    public void setLStrength(String lStrength) {
        this.lStrength = lStrength;
    }

    public String getPiId() {
        return piId;
    }

    public void setPiId(String piId) {
        this.piId = piId;
    }

}
