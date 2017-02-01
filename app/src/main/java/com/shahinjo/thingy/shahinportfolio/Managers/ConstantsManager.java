package com.shahinjo.thingy.shahinportfolio.Managers;

/**
 * Created by shahin on 1/14/17.
 */

public interface ConstantsManager {

    /**
     * Activities
     */
    int SPLASH_DISPLAY_LENGTH = 3000;

    /**
     * InternalStorageManager
     */

    String FILE_NAME_PORTFOLIO = "IS_Portfolio";

    /**
     * SharedPreferencesManager
     */

    //String KEY_ = "prefs.";

    int VALUE_SINGLE = 1;
    int VALUE_ENGAGED = 2;
    int VALUE_MARRIED = 3;

    String KEY_PROFILE_NAME = "prefs.profile.name";
    String KEY_PROFILE_POSITION = "prefs.profile.position";
    String KEY_PROFILE_BIRTH_DATE = "prefs.profile.birth_date";
    String KEY_PROFILE_NATIONALITY = "prefs.profile.nationality";
    String KEY_PROFILE_MARTIAL_STATE = "prefs.profile.martial_state";
    String KEY_PROFILE_ADDRESS = "prefs.profile.address";
    String KEY_PROFILE_PERSONAL_STATEMENT = "prefs.profile.personal_statement";

    String KEY_BUNDLE_PROFILE = "profile_data";
    String KEY_BUNDLE_EDUCATION = "education_data";
    String KEY_BUNDLE_WORK_EXPERIENCE = "work_experience_data";
    String KEY_BUNDLE_PROJECTS = "projects_data";
    String KEY_BUNDLE_SKILLS = "skills_data";
    String KEY_BUNDLE_LANGUAGES = "languages_data";
    String KEY_BUNDLE_HOBBIES_INTERESTS = "hobbies_interests_data";

    String KEY_BUNDLE_BIRTH_DATE = "birth_date";
    String KEY_BUNDLE_NATIONALITY = "nationality";
    String KEY_BUNDLE_MARTIAL_STATE = "martial_state";
    String KEY_BUNDLE_ADDRESS = "address";

    String KEY_BUNDLE_PERSONAL_STATEMENT = "personal_statement";


    String KEY_BUNDLE_CONTACT = "contact_info";




    /**
     * SOAPConnectionManager
     */

    String SOAP_ACTION_ROOT = "";
    String SOAP_NAMESPACE = "";

    /**
     * ConnectionManager
     */

    String BASE_URL = "http://shahinjo.000webhostapp.com/";

    /**
     * Operations
     */

    int OPERATION_PERSONAL_INFO = 1;
    int OPERATION_EDUCATION = 2;
    int OPERATION_WORK_EXPERIENCE = 3;
    int OPERATION_PROJECTS = 5;
    int OPERATION_SKILLS = 4;
    int OPERATION_LANGUAGES = 6;
    int OPERATION_HOBBIES_AND_INTERESTS = 7;


}
