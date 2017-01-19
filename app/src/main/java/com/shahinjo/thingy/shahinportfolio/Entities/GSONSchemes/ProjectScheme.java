
package com.shahinjo.thingy.shahinportfolio.Entities.GSONSchemes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ProjectScheme implements Serializable {

    @SerializedName("p_id")
    @Expose
    private String pId;
    @SerializedName("p_name")
    @Expose
    private String pName;
    @SerializedName("p_description")
    @Expose
    private String pDescription;
    @SerializedName("p_team_company")
    @Expose
    private String pTeamCompany;
    @SerializedName("p_image_name")
    @Expose
    private String pImageName;
    @SerializedName("p_image_path")
    @Expose
    private String pImagePath;
    @SerializedName("p_link")
    @Expose
    private String pLink;
    @SerializedName("pi_id")
    @Expose
    private String piId;

    public String getPId() {
        return pId;
    }

    public void setPId(String pId) {
        this.pId = pId;
    }

    public String getPName() {
        return pName;
    }

    public void setPName(String pName) {
        this.pName = pName;
    }

    public String getPDescription() {
        return pDescription;
    }

    public void setPDescription(String pDescription) {
        this.pDescription = pDescription;
    }

    public String getPTeamCompany() {
        return pTeamCompany;
    }

    public void setPTeamCompany(String pTeamCompany) {
        this.pTeamCompany = pTeamCompany;
    }

    public String getPImageName() {
        return pImageName;
    }

    public void setPImageName(String pImageName) {
        this.pImageName = pImageName;
    }

    public String getPImagePath() {
        return pImagePath;
    }

    public void setPImagePath(String pImagePath) {
        this.pImagePath = pImagePath;
    }

    public String getPLink() {
        return pLink;
    }

    public void setPLink(String pLink) {
        this.pLink = pLink;
    }

    public String getPiId() {
        return piId;
    }

    public void setPiId(String piId) {
        this.piId = piId;
    }

}
