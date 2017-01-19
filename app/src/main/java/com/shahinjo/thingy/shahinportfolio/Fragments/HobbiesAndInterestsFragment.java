package com.shahinjo.thingy.shahinportfolio.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.shahinjo.thingy.shahinportfolio.Adapters.HobbiesAndInterestsAdapter;
import com.shahinjo.thingy.shahinportfolio.Entities.GSONSchemes.EducationTrainingScheme;
import com.shahinjo.thingy.shahinportfolio.Entities.GSONSchemes.HobbyInterestScheme;
import com.shahinjo.thingy.shahinportfolio.Entities.GSONSchemes.ProfileScheme;
import com.shahinjo.thingy.shahinportfolio.Entities.HobbyInterestEntity;
import com.shahinjo.thingy.shahinportfolio.R;

import java.util.ArrayList;

/**
 * Created by shahin on 1/19/17.
 */

public class HobbiesAndInterestsFragment extends Fragment {

    public HobbiesAndInterestsFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_hobbies_and_interests, container, false);
        GridView gridView = (GridView) rootView.findViewById(R.id.grid_hobbies_and_interests);

        ArrayList<HobbyInterestScheme> hobbiesInterestsList = (ArrayList<HobbyInterestScheme>) getArguments().getSerializable("hobbies_interests_data");

        if(hobbiesInterestsList != null) {
            gridView.setAdapter(new HobbiesAndInterestsAdapter(rootView.getContext(), hobbiesInterestsList));
        }

        return rootView;
    }
}
