
package com.shahinjo.thingy.shahinportfolio.Entities.GSONSchemes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HobbyInterestScheme {

    @SerializedName("hi_id")
    @Expose
    private String hiId;
    @SerializedName("hi_name")
    @Expose
    private String hiName;
    @SerializedName("hi_image_name")
    @Expose
    private String hiImageName;
    @SerializedName("hi_image_path")
    @Expose
    private String hiImagePath;
    @SerializedName("pi_id")
    @Expose
    private String piId;

    public String getHiId() {
        return hiId;
    }

    public void setHiId(String hiId) {
        this.hiId = hiId;
    }

    public String getHiName() {
        return hiName;
    }

    public void setHiName(String hiName) {
        this.hiName = hiName;
    }

    public String getHiImageName() {
        return hiImageName;
    }

    public void setHiImageName(String hiImageName) {
        this.hiImageName = hiImageName;
    }

    public String getHiImagePath() {
        return hiImagePath;
    }

    public void setHiImagePath(String hiImagePath) {
        this.hiImagePath = hiImagePath;
    }

    public String getPiId() {
        return piId;
    }

    public void setPiId(String piId) {
        this.piId = piId;
    }

}
