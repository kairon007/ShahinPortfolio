package com.shahinjo.thingy.shahinportfolio.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shahinjo.thingy.shahinportfolio.CustomViews.Orientation;
import com.shahinjo.thingy.shahinportfolio.CustomViews.TimeLineAdapter;
import com.shahinjo.thingy.shahinportfolio.CustomViews.TimeLineModel;
import com.shahinjo.thingy.shahinportfolio.Entities.GSONSchemes.EducationTrainingScheme;
import com.shahinjo.thingy.shahinportfolio.R;

import java.util.ArrayList;

/**
 * Created by shahin on 1/19/17.
 */

public class EducationAndTrainingFragment extends Fragment {

    Context context;
    private RecyclerView recyclerView;
    private TimeLineAdapter timeLineAdapter;
    private Orientation orientation;
    private ArrayList<EducationTrainingScheme> educationData = new ArrayList<>();
    private ArrayList<TimeLineModel> timelineData = new ArrayList<>();

    public EducationAndTrainingFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_education_and_training, container, false);
        this.context = getActivity();//rootView.getContext();
        educationData = (ArrayList<EducationTrainingScheme>) getArguments().getSerializable("education_data");

        timelineData = new ArrayList<>();

        for (int i = 0; i < educationData.size(); i++) {

            EducationTrainingScheme currentScheme = educationData.get(i);
            TimeLineModel newModel = new TimeLineModel();
            newModel.setPeriod(String.format("%s - %s", currentScheme.getEtFrom(), currentScheme.getEtTo()));
            newModel.setDegree(currentScheme.getEtEducationDegree());
            newModel.setMajor(currentScheme.getEtMajor());
            newModel.setLocation(currentScheme.getEtInstitution());

            timelineData.add(newModel);
        }

        orientation = Orientation.vertical;

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);


        recyclerView.setLayoutManager(getLinearLayoutManager());
        recyclerView.setHasFixedSize(true);


        timeLineAdapter = new TimeLineAdapter(context, timelineData, orientation);
        recyclerView.setAdapter(timeLineAdapter);

        return rootView;
    }

    private LinearLayoutManager getLinearLayoutManager() {

        if (orientation == Orientation.horizontal) {

            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
            return linearLayoutManager;
        } else {

            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
            return linearLayoutManager;
        }

    }

}
