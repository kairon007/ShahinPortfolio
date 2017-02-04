package com.shahinjo.thingy.shahinportfolio.Entities.GSONSchemes;

/**
 * Created by y.shahin on 2/4/2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class AlbumImagesScheme implements Serializable {

    @SerializedName("ai_id")
    @Expose
    private String aiId;
    @SerializedName("ai_image_title")
    @Expose
    private String aiImageTitle;
    @SerializedName("ai_image_description")
    @Expose
    private String aiImageDescription;
    @SerializedName("ai_image_url")
    @Expose
    private String aiImageUrl;
    @SerializedName("ga_id")
    @Expose
    private String gaId;

    public String getAiId() {
        return aiId;
    }

    public void setAiId(String aiId) {
        this.aiId = aiId;
    }

    public String getAiImageTitle() {
        return aiImageTitle;
    }

    public void setAiImageTitle(String aiImageTitle) {
        this.aiImageTitle = aiImageTitle;
    }

    public String getAiImageDescription() {
        return aiImageDescription;
    }

    public void setAiImageDescription(String aiImageDescription) {
        this.aiImageDescription = aiImageDescription;
    }

    public String getAiImageUrl() {
        return aiImageUrl;
    }

    public void setAiImageUrl(String aiImageUrl) {
        this.aiImageUrl = aiImageUrl;
    }

    public String getGaId() {
        return gaId;
    }

    public void setGaId(String gaId) {
        this.gaId = gaId;
    }

}