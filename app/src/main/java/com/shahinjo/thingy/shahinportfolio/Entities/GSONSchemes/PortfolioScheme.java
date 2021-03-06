
package com.shahinjo.thingy.shahinportfolio.Entities.GSONSchemes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class PortfolioScheme implements Serializable {

    @SerializedName("ProfileScheme")
    @Expose
    private ProfileScheme profileScheme;
    @SerializedName("ContactingListScheme")
    @Expose
    private List<ContactingListScheme> contactingListScheme = null;
    @SerializedName("EducationTrainingScheme")
    @Expose
    private List<EducationTrainingScheme> educationTrainingScheme = null;
    @SerializedName("WorkExperienceScheme")
    @Expose
    private List<WorkExperienceScheme> workExperienceScheme = null;
    @SerializedName("SkillScheme")
    @Expose
    private List<SkillScheme> skillScheme = null;
    @SerializedName("ProjectScheme")
    @Expose
    private List<ProjectScheme> projectScheme = null;
    @SerializedName("LanguageScheme")
    @Expose
    private List<LanguageScheme> languageScheme = null;
    @SerializedName("HobbyInterestScheme")
    @Expose
    private List<HobbyInterestScheme> hobbyInterestScheme = null;

    public ProfileScheme getProfileScheme() {
        return profileScheme;
    }

    public void setProfileScheme(ProfileScheme profileScheme) {
        this.profileScheme = profileScheme;
    }

    public List<EducationTrainingScheme> getEducationTrainingScheme() {
        return educationTrainingScheme;
    }

    public void setEducationTrainingScheme(List<EducationTrainingScheme> educationTrainingScheme) {
        this.educationTrainingScheme = educationTrainingScheme;
    }

    public List<WorkExperienceScheme> getWorkExperienceScheme() {
        return workExperienceScheme;
    }

    public void setWorkExperienceScheme(List<WorkExperienceScheme> workExperienceScheme) {
        this.workExperienceScheme = workExperienceScheme;
    }

    public List<SkillScheme> getSkillScheme() {
        return skillScheme;
    }

    public void setSkillScheme(List<SkillScheme> skillScheme) {
        this.skillScheme = skillScheme;
    }

    public List<ProjectScheme> getProjectScheme() {
        return projectScheme;
    }

    public void setProjectScheme(List<ProjectScheme> projectScheme) {
        this.projectScheme = projectScheme;
    }

    public List<LanguageScheme> getLanguageScheme() {
        return languageScheme;
    }

    public void setLanguageScheme(List<LanguageScheme> languageScheme) {
        this.languageScheme = languageScheme;
    }

    public List<HobbyInterestScheme> getHobbyInterestScheme() {
        return hobbyInterestScheme;
    }

    public void setHobbyInterestScheme(List<HobbyInterestScheme> hobbyInterestScheme) {
        this.hobbyInterestScheme = hobbyInterestScheme;
    }

    public List<ContactingListScheme> getContactingListScheme() {
        return contactingListScheme;
    }

    public void setContactingListScheme(List<ContactingListScheme> contactingListScheme) {
        this.contactingListScheme = contactingListScheme;
    }
}
