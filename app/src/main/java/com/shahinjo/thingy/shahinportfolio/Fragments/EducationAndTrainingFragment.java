package com.shahinjo.thingy.shahinportfolio.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shahinjo.thingy.shahinportfolio.R;

/**
 * Created by shahin on 1/19/17.
 */

public class EducationAndTrainingFragment extends Fragment {

    public EducationAndTrainingFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_education_and_training, container, false);


        return rootView;
    }

}
