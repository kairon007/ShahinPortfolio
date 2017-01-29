package com.shahinjo.thingy.shahinportfolio.Adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.shahinjo.thingy.shahinportfolio.Entities.GSONSchemes.ProfileScheme;
import com.shahinjo.thingy.shahinportfolio.Fragments.ContactInformationFragment;
import com.shahinjo.thingy.shahinportfolio.Fragments.PersonalInfoFragment;
import com.shahinjo.thingy.shahinportfolio.Fragments.PersonalStatementFragment;
import com.shahinjo.thingy.shahinportfolio.Managers.ConstantsManager;

/**
 * Created by y.shahin on 1/29/2017.
 */

public class ProfilePagerAdapter extends FragmentStatePagerAdapter {


    private static final int PAGES_COUNT = 3;

    private ProfileScheme profileData;

    public ProfilePagerAdapter(FragmentManager fm, ProfileScheme profileData) {
        super(fm);
        this.profileData = profileData;
    }

    @Override
    public Fragment getItem(int position) {

        Bundle bundle = new Bundle();

        switch (position) {
            case 0:
                PersonalInfoFragment tabPersonalInfo = new PersonalInfoFragment();
                bundle.putString(ConstantsManager.KEY_BUNDLE_BIRTH_DATE, profileData.getPiBirthDate());
                bundle.putString(ConstantsManager.KEY_BUNDLE_NATIONALITY, profileData.getPiNationality());
                bundle.putString(ConstantsManager.KEY_BUNDLE_MARTIAL_STATE, profileData.getPiMartialState());
                bundle.putString(ConstantsManager.KEY_BUNDLE_ADDRESS, profileData.getPiAddress());
                tabPersonalInfo.setArguments(bundle);
                return tabPersonalInfo;
            case 1:
                PersonalStatementFragment tabPersonalStatement = new PersonalStatementFragment();

                bundle.putString(ConstantsManager.KEY_BUNDLE_PERSONAL_STATEMENT, profileData.getPiPersonalStatement());

                tabPersonalStatement.setArguments(bundle);
                return tabPersonalStatement;
            case 2:
                ContactInformationFragment tabContactInfo = new ContactInformationFragment();

                //bundle.putSerializable(ConstantsManager.KEY_BUNDLE_CONTACT, profileData.get);

                tabContactInfo.setArguments(bundle);
                return tabContactInfo;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return PAGES_COUNT;
    }
}