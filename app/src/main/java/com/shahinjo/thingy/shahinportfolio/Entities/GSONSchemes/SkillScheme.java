
package com.shahinjo.thingy.shahinportfolio.Entities.GSONSchemes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class SkillScheme implements Serializable {

    @SerializedName("s_id")
    @Expose
    private String sId;
    @SerializedName("s_name")
    @Expose
    private String sName;
    @SerializedName("s_strength")
    @Expose
    private String sStrength;
    @SerializedName("pi_id")
    @Expose
    private String piId;

    public String getSId() {
        return sId;
    }

    public void setSId(String sId) {
        this.sId = sId;
    }

    public String getSName() {
        return sName;
    }

    public void setSName(String sName) {
        this.sName = sName;
    }

    public String getSStrength() {
        return sStrength;
    }

    public void setSStrength(String sStrength) {
        this.sStrength = sStrength;
    }

    public String getPiId() {
        return piId;
    }

    public void setPiId(String piId) {
        this.piId = piId;
    }

}
