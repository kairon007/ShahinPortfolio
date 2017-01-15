package com.shahinjo.thingy.shahinportfolio.Managers;

import android.content.SharedPreferences;

import com.shahinjo.thingy.shahinportfolio.Entities.MartialStateEnum;
import com.shahinjo.thingy.shahinportfolio.Entities.ProfileEntity;

/**
 * Created by shahin on 1/14/17.
 */

public class SharedPreferencesManager {

    private static SharedPreferences sharedPref;

    public static SharedPreferences getSharedPreferences() {
        return sharedPref;
    }

    public static void setSharedPreferences(SharedPreferences sharedPref) {
        sharedPref = sharedPref;
    }

    public static void logOutFromPrefs() {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.clear();
        editor.commit();
    }

    public static void storePersonalInformation(ProfileEntity profile) {

        SharedPreferences.Editor editor = sharedPref.edit();

        editor.putString(ConstantsManager.KEY_PROFILE_NAME, profile.getName());
        editor.putString(ConstantsManager.KEY_PROFILE_POSITION, profile.getPosition());
        editor.putString(ConstantsManager.KEY_PROFILE_BIRTH_DATE, profile.getBirthDate());
        editor.putString(ConstantsManager.KEY_PROFILE_NATIONALITY, profile.getNationality());


        switch (profile.getMartialState()) {
            case SINGLE:
                editor.putInt(ConstantsManager.KEY_PROFILE_MARTIAL_STATE, ConstantsManager.VALUE_SINGLE);
                break;

            case ENGAGED:
                editor.putInt(ConstantsManager.KEY_PROFILE_MARTIAL_STATE, ConstantsManager.VALUE_ENGAGED);
                break;

            case MARRIED:
                editor.putInt(ConstantsManager.KEY_PROFILE_MARTIAL_STATE, ConstantsManager.VALUE_MARRIED);
                break;
        }

        editor.putString(ConstantsManager.KEY_PROFILE_ADDRESS, profile.getAddress());
        editor.putString(ConstantsManager.KEY_PROFILE_PERSONAL_STATEMENT, profile.getPersonalStatement());


        editor.commit();
    }

    public static ProfileEntity getPersonalInformation() {

        ProfileEntity profile = new ProfileEntity();

        profile.setName(sharedPref.getString(ConstantsManager.KEY_PROFILE_NAME, ""));
        profile.setPosition(sharedPref.getString(ConstantsManager.KEY_PROFILE_POSITION, ""));
        profile.setBirthDate(sharedPref.getString(ConstantsManager.KEY_PROFILE_BIRTH_DATE, ""));
        profile.setNationality(sharedPref.getString(ConstantsManager.KEY_PROFILE_NATIONALITY, ""));

        switch (sharedPref.getInt(ConstantsManager.KEY_PROFILE_MARTIAL_STATE, 0)) {

            case ConstantsManager.VALUE_SINGLE:
                profile.setMartialState(MartialStateEnum.SINGLE);
                break;

            case ConstantsManager.VALUE_ENGAGED:
                profile.setMartialState(MartialStateEnum.ENGAGED);
                break;

            case ConstantsManager.VALUE_MARRIED:
                profile.setMartialState(MartialStateEnum.MARRIED);
                break;

        }

        profile.setAddress(sharedPref.getString(ConstantsManager.KEY_PROFILE_ADDRESS, ""));
        profile.setPersonalStatement(sharedPref.getString(ConstantsManager.KEY_PROFILE_PERSONAL_STATEMENT, ""));


        return profile;
    }

}
