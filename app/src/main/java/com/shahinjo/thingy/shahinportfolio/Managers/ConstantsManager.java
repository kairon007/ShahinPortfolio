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


    /**
     * SOAPConnectionManager
     */

    String SOAP_ACTION_ROOT = "";
    String SOAP_NAMESPACE = "";


}
