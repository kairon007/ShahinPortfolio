package com.shahinjo.thingy.shahinportfolio.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.shahinjo.thingy.shahinportfolio.Activities.MainActivity;
import com.shahinjo.thingy.shahinportfolio.CustomViews.Orientation;
import com.shahinjo.thingy.shahinportfolio.CustomViews.TimeLineAdapter;
import com.shahinjo.thingy.shahinportfolio.CustomViews.TimeLineModel;
import com.shahinjo.thingy.shahinportfolio.Entities.GSONSchemes.EducationTrainingScheme;
import com.shahinjo.thingy.shahinportfolio.Entities.GSONSchemes.PortfolioScheme;
import com.shahinjo.thingy.shahinportfolio.Managers.ConstantsManager;
import com.shahinjo.thingy.shahinportfolio.Managers.PortfolioEndPoint;
import com.shahinjo.thingy.shahinportfolio.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by shahin on 1/19/17.
 */

public class EducationAndTrainingFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    Context context;
    private RecyclerView recyclerView;
    private TimeLineAdapter timeLineAdapter;
    private SwipeRefreshLayout swipeContainer;
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


        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        swipeContainer = (SwipeRefreshLayout) rootView.findViewById(R.id.swipe_container);
        swipeContainer.setOnRefreshListener(this);

        orientation = Orientation.vertical;

        educationData = (ArrayList<EducationTrainingScheme>) getArguments().getSerializable("education_data");

        fillData();

        return rootView;
    }

    private void fillData() {
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

        recyclerView.setLayoutManager(getLinearLayoutManager());
        recyclerView.setHasFixedSize(true);


        timeLineAdapter = new TimeLineAdapter(context, timelineData, orientation);
        recyclerView.setAdapter(timeLineAdapter);
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

    @Override
    public void onRefresh() {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantsManager.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        PortfolioEndPoint service = retrofit.create(PortfolioEndPoint.class);

        final Call<ArrayList<EducationTrainingScheme>> apiCall = service.getEducationData(1, ConstantsManager.OPERATION_EDUCATION);

        apiCall.enqueue(new Callback<ArrayList<EducationTrainingScheme>>() {
            @Override
            public void onResponse(Call<ArrayList<EducationTrainingScheme>> call, Response<ArrayList<EducationTrainingScheme>> response) {

                Log.i("RETROFIT", "onResponse Called");

                ArrayList<EducationTrainingScheme> educationSchemeList = response.body();

                if (educationSchemeList == null) {
                    Toast.makeText(getActivity(), "Something wrong happened, Please try later.", Toast.LENGTH_LONG).show();
                    return;
                }
                //storePortfolioInternally();

                educationData = educationSchemeList;
                fillData();
                swipeContainer.setRefreshing(false);
            }

            @Override
            public void onFailure(Call<ArrayList<EducationTrainingScheme>> call, Throwable t) {

                String err = t.getMessage() == null ? "" : t.getMessage();
                Toast.makeText(getActivity(), "Service Call Failure \n" + err, Toast.LENGTH_LONG).show();
                Log.e("RETROFIT", err);
                swipeContainer.setRefreshing(false);

            }
        });
    }
}
