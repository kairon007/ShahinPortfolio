package com.shahinjo.thingy.shahinportfolio.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.shahinjo.thingy.shahinportfolio.Adapters.SkillsAdapter;
import com.shahinjo.thingy.shahinportfolio.Entities.GSONSchemes.SkillScheme;
import com.shahinjo.thingy.shahinportfolio.R;

import java.util.ArrayList;

/**
 * Created by shahin on 1/19/17.
 */

public class SkillsFragment extends Fragment {

    public SkillsFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_skills, container, false);
        ListView skillsList = (ListView) rootView.findViewById(R.id.list_skills);

        ArrayList<SkillScheme> skillsData = (ArrayList<SkillScheme>) getArguments().getSerializable("skills_data");

        skillsList.setAdapter(new SkillsAdapter(rootView.getContext(), R.layout.row_skill, skillsData));


        return rootView;
    }
}
