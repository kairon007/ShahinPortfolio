package com.shahinjo.thingy.shahinportfolio.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shahinjo.thingy.shahinportfolio.Entities.GSONSchemes.ProfileScheme;
import com.shahinjo.thingy.shahinportfolio.R;

/**
 * Created by y.shahin on 1/18/2017.
 */

public class AboutMeFragment extends Fragment {

    ViewHolder views;

    public AboutMeFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_about_me,container, false);

        ProfileScheme profileData = (ProfileScheme) getArguments().getSerializable("profile_data");

        views = new ViewHolder();

        views.tvFullName = (TextView) rootView.findViewById(R.id.tv_full_name);
        views.tvPosition = (TextView) rootView.findViewById(R.id.tv_position);
        views.tvBirthDate = (TextView) rootView.findViewById(R.id.tv_birth_date);
        views.tvNationality = (TextView) rootView.findViewById(R.id.tv_nationality);
        views.tvMartialState = (TextView) rootView.findViewById(R.id.tv_martial_state);
        views.tvAddress = (TextView) rootView.findViewById(R.id.tv_address);
        views.tvPersonalStatement = (TextView) rootView.findViewById(R.id.tv_personal_statement);

        views.tvFullName.setText(profileData.getPiFullName());
        views.tvPosition.setText(profileData.getPiPosition());
        views.tvBirthDate.setText(profileData.getPiBirthDate());
        views.tvNationality.setText(profileData.getPiNationality());
        views.tvMartialState.setText(profileData.getPiMartialState());
        views.tvAddress.setText(profileData.getPiAddress());
        views.tvPersonalStatement.setText(profileData.getPiPersonalStatement());


        return rootView;
    }

    public static class ViewHolder {

        public TextView tvFullName;
        public TextView tvPosition;
        public TextView tvBirthDate;
        public TextView tvNationality;
        public TextView tvMartialState;
        public TextView tvAddress;
        public TextView tvPersonalStatement;

    }
}
