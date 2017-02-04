package com.shahinjo.thingy.shahinportfolio.Entities.GSONSchemes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by y.shahin on 2/4/2017.
 */

public class GalleryAlbumsScheme implements Serializable {

    @SerializedName("ga_id")
    @Expose
    private String gaId;
    @SerializedName("ga_name")
    @Expose
    private String gaName;
    @SerializedName("ga_thumbnail_url")
    @Expose
    private String gaThumbnailUrl;
    @SerializedName("pi_id")
    @Expose
    private String piId;

    public String getGaId() {
        return gaId;
    }

    public void setGaId(String gaId) {
        this.gaId = gaId;
    }

    public String getGaName() {
        return gaName;
    }

    public void setGaName(String gaName) {
        this.gaName = gaName;
    }

    public String getGaThumbnailUrl() {
        return gaThumbnailUrl;
    }

    public void setGaThumbnailUrl(String gaThumbnailUrl) {
        this.gaThumbnailUrl = gaThumbnailUrl;
    }

    public String getPiId() {
        return piId;
    }

    public void setPiId(String piId) {
        this.piId = piId;
    }

}