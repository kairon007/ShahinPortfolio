package com.shahinjo.thingy.shahinportfolio.Entities;

import java.util.ArrayList;

/**
 * Created by shahin on 1/13/17.
 */

public class ProfileEntity extends PortfolioGeneralClass {

    // Image profile image

    private String name;
    private String position;
    private String birthDate;
    private String nationality;
    private MartialStateEnum martialState;
    private String address;
    private ArrayList<ContactEntity> contactingList;

    private String personalStatement;

    private ArrayList<EducationTrainingEntity> educationAndTrainingList;

    private ArrayList<WorkExperienceEntity> workExperienceList;

    private ArrayList<ProjectEntity> projectsList;

    private ArrayList<SkillEntity> skillsList;

    private ArrayList<LanguageEntity> languagesList;

    private ArrayList<HobbyInterestEntity> hobbiesAndInterestsList;


    public ProfileEntity() {

        birthDate = "01/01/1950";

        martialState = MartialStateEnum.SINGLE;

        contactingList = new ArrayList<>();
        educationAndTrainingList = new ArrayList<>();
        workExperienceList = new ArrayList<>();
        projectsList = new ArrayList<>();
        skillsList = new ArrayList<>();
        languagesList = new ArrayList<>();
        hobbiesAndInterestsList = new ArrayList<>();

    }

    public void addContactMethod(ContactEntity contactEntity) {
        contactingList.add(contactEntity);
    }

    public void addEducationAndTraining(EducationTrainingEntity educationTrainingEntity) {
        educationAndTrainingList.add(educationTrainingEntity);
    }

    public void addWorkExperience(WorkExperienceEntity workExperienceEntity) {
        workExperienceList.add(workExperienceEntity);
    }

    public void addProject(ProjectEntity projectEntity) {
        projectsList.add(projectEntity);
    }

    public void addSkill(SkillEntity skillEntity) {
        skillsList.add(skillEntity);
    }

    public void addLanguage(LanguageEntity languageEntity) {
        languagesList.add(languageEntity);
    }

    public void addHobbyOrInterest(HobbyInterestEntity hobbyInterestEntity) {
        hobbiesAndInterestsList.add(hobbyInterestEntity);
    }

    /**
     * About me details
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public MartialStateEnum getMartialState() {
        return martialState;
    }

    public void setMartialState(MartialStateEnum martialState) {
        this.martialState = martialState;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<ContactEntity> getContactingList() {
        return contactingList;
    }

    public void setContactingList(ArrayList<ContactEntity> contactingList) {
        this.contactingList = contactingList;
    }

    /**
     * Main Parts of the Portfolio
     */
    public String getPersonalStatement() {
        return personalStatement;
    }

    public void setPersonalStatement(String personalStatement) {
        this.personalStatement = personalStatement;
    }

    public ArrayList<EducationTrainingEntity> getEducationAndTrainingList() {
        return educationAndTrainingList;
    }

    public void setEducationAndTrainingList(ArrayList<EducationTrainingEntity> educationAndTrainingList) {
        this.educationAndTrainingList = educationAndTrainingList;
    }

    public ArrayList<WorkExperienceEntity> getWorkExperienceList() {
        return workExperienceList;
    }

    public void setWorkExperienceList(ArrayList<WorkExperienceEntity> workExperienceList) {
        this.workExperienceList = workExperienceList;
    }

    public ArrayList<ProjectEntity> getProjectsList() {
        return projectsList;
    }

    public void setProjectsList(ArrayList<ProjectEntity> projectsList) {
        this.projectsList = projectsList;
    }

    public ArrayList<SkillEntity> getSkillsList() {
        return skillsList;
    }

    public void setSkillsList(ArrayList<SkillEntity> skillsList) {
        this.skillsList = skillsList;
    }

    public ArrayList<LanguageEntity> getLanguagesList() {
        return languagesList;
    }

    public void setLanguagesList(ArrayList<LanguageEntity> languagesList) {
        this.languagesList = languagesList;
    }

    public ArrayList<HobbyInterestEntity> getHobbiesAndInterestsList() {
        return hobbiesAndInterestsList;
    }

    public void setHobbiesAndInterestsList(ArrayList<HobbyInterestEntity> hobbiesAndInterestsList) {
        this.hobbiesAndInterestsList = hobbiesAndInterestsList;
    }
}
