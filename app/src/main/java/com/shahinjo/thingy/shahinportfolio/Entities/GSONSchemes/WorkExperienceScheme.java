
package com.shahinjo.thingy.shahinportfolio.Entities.GSONSchemes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WorkExperienceScheme {

    @SerializedName("we_id")
    @Expose
    private String weId;
    @SerializedName("we_company_or_team")
    @Expose
    private String weCompanyOrTeam;
    @SerializedName("we_from")
    @Expose
    private String weFrom;
    @SerializedName("we_to")
    @Expose
    private String weTo;
    @SerializedName("we_position")
    @Expose
    private String wePosition;
    @SerializedName("we_years")
    @Expose
    private String weYears;
    @SerializedName("we_description")
    @Expose
    private String weDescription;
    @SerializedName("pi_id")
    @Expose
    private String piId;

    public String getWeId() {
        return weId;
    }

    public void setWeId(String weId) {
        this.weId = weId;
    }

    public String getWeCompanyOrTeam() {
        return weCompanyOrTeam;
    }

    public void setWeCompanyOrTeam(String weCompanyOrTeam) {
        this.weCompanyOrTeam = weCompanyOrTeam;
    }

    public String getWeFrom() {
        return weFrom;
    }

    public void setWeFrom(String weFrom) {
        this.weFrom = weFrom;
    }

    public String getWeTo() {
        return weTo;
    }

    public void setWeTo(String weTo) {
        this.weTo = weTo;
    }

    public String getWePosition() {
        return wePosition;
    }

    public void setWePosition(String wePosition) {
        this.wePosition = wePosition;
    }

    public String getWeYears() {
        return weYears;
    }

    public void setWeYears(String weYears) {
        this.weYears = weYears;
    }

    public String getWeDescription() {
        return weDescription;
    }

    public void setWeDescription(String weDescription) {
        this.weDescription = weDescription;
    }

    public String getPiId() {
        return piId;
    }

    public void setPiId(String piId) {
        this.piId = piId;
    }

}
