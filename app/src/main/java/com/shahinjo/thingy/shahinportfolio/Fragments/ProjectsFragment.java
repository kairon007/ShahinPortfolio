package com.shahinjo.thingy.shahinportfolio.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.shahinjo.thingy.shahinportfolio.Adapters.ProjectsAdapter;
import com.shahinjo.thingy.shahinportfolio.Entities.GSONSchemes.ProjectScheme;
import com.shahinjo.thingy.shahinportfolio.R;

import java.util.ArrayList;

/**
 * Created by shahin on 1/19/17.
 */

public class ProjectsFragment extends Fragment {

    public ProjectsFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_projects, container, false);
        ListView lvProjects = (ListView) rootView.findViewById(R.id.list_projects);

        ArrayList<ProjectScheme> projectsList = (ArrayList<ProjectScheme>) getArguments().getSerializable("projects_data");

        if (projectsList != null) {
            lvProjects.setAdapter(new ProjectsAdapter(rootView.getContext(), R.layout.row_project, projectsList));
        }


        return rootView;
    }

}
