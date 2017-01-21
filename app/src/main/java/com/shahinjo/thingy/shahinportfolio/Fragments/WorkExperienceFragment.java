package com.shahinjo.thingy.shahinportfolio.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.shahinjo.thingy.shahinportfolio.Adapters.WorkExperienceAdapter;
import com.shahinjo.thingy.shahinportfolio.Entities.GSONSchemes.WorkExperienceScheme;
import com.shahinjo.thingy.shahinportfolio.R;

import java.util.ArrayList;

/**
 * Created by shahin on 1/19/17.
 */

public class WorkExperienceFragment extends Fragment {

    public WorkExperienceFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_work_experience, container, false);
        GridView gridView = (GridView) rootView.findViewById(R.id.grid_work_experience);

        ArrayList<WorkExperienceScheme> workExperienceList = (ArrayList<WorkExperienceScheme>) getArguments().getSerializable("work_experience_data");

        if (workExperienceList != null) {
            gridView.setAdapter(new WorkExperienceAdapter(rootView.getContext(), workExperienceList));
        }

        return rootView;
    }
}
