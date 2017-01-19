
package com.shahinjo.thingy.shahinportfolio.Entities.GSONSchemes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ProfileScheme implements Serializable {

    @SerializedName("pi_id")
    @Expose
    private String piId;
    @SerializedName("pi_full_name")
    @Expose
    private String piFullName;
    @SerializedName("pi_position")
    @Expose
    private String piPosition;
    @SerializedName("pi_personal_statement")
    @Expose
    private String piPersonalStatement;
    @SerializedName("pi_birth_date")
    @Expose
    private String piBirthDate;
    @SerializedName("pi_nationality")
    @Expose
    private String piNationality;
    @SerializedName("pi_martial_state")
    @Expose
    private String piMartialState;
    @SerializedName("pi_address")
    @Expose
    private String piAddress;

    public String getPiId() {
        return piId;
    }

    public void setPiId(String piId) {
        this.piId = piId;
    }

    public String getPiFullName() {
        return piFullName;
    }

    public void setPiFullName(String piFullName) {
        this.piFullName = piFullName;
    }

    public String getPiPosition() {
        return piPosition;
    }

    public void setPiPosition(String piPosition) {
        this.piPosition = piPosition;
    }

    public String getPiPersonalStatement() {
        return piPersonalStatement;
    }

    public void setPiPersonalStatement(String piPersonalStatement) {
        this.piPersonalStatement = piPersonalStatement;
    }

    public String getPiBirthDate() {
        return piBirthDate;
    }

    public void setPiBirthDate(String piBirthDate) {
        this.piBirthDate = piBirthDate;
    }

    public String getPiNationality() {
        return piNationality;
    }

    public void setPiNationality(String piNationality) {
        this.piNationality = piNationality;
    }

    public String getPiMartialState() {
        return piMartialState;
    }

    public void setPiMartialState(String piMartialState) {
        this.piMartialState = piMartialState;
    }

    public String getPiAddress() {
        return piAddress;
    }

    public void setPiAddress(String piAddress) {
        this.piAddress = piAddress;
    }

}
