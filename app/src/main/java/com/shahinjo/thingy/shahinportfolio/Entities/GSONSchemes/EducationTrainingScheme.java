
package com.shahinjo.thingy.shahinportfolio.Entities.GSONSchemes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class EducationTrainingScheme implements Serializable {

    @SerializedName("et_id")
    @Expose
    private String etId;
    @SerializedName("et_from")
    @Expose
    private String etFrom;
    @SerializedName("et_to")
    @Expose
    private String etTo;
    @SerializedName("et_education_degree")
    @Expose
    private String etEducationDegree;
    @SerializedName("et_major")
    @Expose
    private String etMajor;
    @SerializedName("et_institution")
    @Expose
    private String etInstitution;
    @SerializedName("pi_id")
    @Expose
    private String piId;

    public String getEtId() {
        return etId;
    }

    public void setEtId(String etId) {
        this.etId = etId;
    }

    public String getEtFrom() {
        return etFrom;
    }

    public void setEtFrom(String etFrom) {
        this.etFrom = etFrom;
    }

    public String getEtTo() {
        return etTo;
    }

    public void setEtTo(String etTo) {
        this.etTo = etTo;
    }

    public String getEtEducationDegree() {
        return etEducationDegree;
    }

    public void setEtEducationDegree(String etEducationDegree) {
        this.etEducationDegree = etEducationDegree;
    }

    public String getEtMajor() {
        return etMajor;
    }

    public void setEtMajor(String etMajor) {
        this.etMajor = etMajor;
    }

    public String getEtInstitution() {
        return etInstitution;
    }

    public void setEtInstitution(String etInstitution) {
        this.etInstitution = etInstitution;
    }

    public String getPiId() {
        return piId;
    }

    public void setPiId(String piId) {
        this.piId = piId;
    }

}
