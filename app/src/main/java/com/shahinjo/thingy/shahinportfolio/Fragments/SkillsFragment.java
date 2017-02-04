package com.shahinjo.thingy.shahinportfolio.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.shahinjo.thingy.shahinportfolio.Adapters.SkillsAdapter;
import com.shahinjo.thingy.shahinportfolio.Entities.GSONSchemes.EducationTrainingScheme;
import com.shahinjo.thingy.shahinportfolio.Entities.GSONSchemes.SkillScheme;
import com.shahinjo.thingy.shahinportfolio.Managers.ConstantsManager;
import com.shahinjo.thingy.shahinportfolio.Managers.PortfolioEndPoint;
import com.shahinjo.thingy.shahinportfolio.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by shahin on 1/19/17.
 */

public class SkillsFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    private Context context;

    private ListView skillsList;
    private SwipeRefreshLayout swipeContainer;

    private ArrayList<SkillScheme> skillsData;

    public SkillsFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_skills, container, false);

        this.context = rootView.getContext();

        skillsList = (ListView) rootView.findViewById(R.id.list_skills);
        swipeContainer = (SwipeRefreshLayout) rootView.findViewById(R.id.swipe_container);
        swipeContainer.setOnRefreshListener(this);

        skillsData = (ArrayList<SkillScheme>) getArguments().getSerializable(ConstantsManager.KEY_BUNDLE_SKILLS);

        fillData();


        return rootView;
    }

    private void fillData() {
        if (skillsData != null) {
            skillsList.setAdapter(new SkillsAdapter(context, R.layout.row_skill, skillsData));
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

        final Call<ArrayList<SkillScheme>> apiCall = service.getSkillsData(1, ConstantsManager.OPERATION_SKILLS);

        apiCall.enqueue(new Callback<ArrayList<SkillScheme>>() {
            @Override
            public void onResponse(Call<ArrayList<SkillScheme>> call, Response<ArrayList<SkillScheme>> response) {

                Log.i("RETROFIT", "onResponse Called");

                ArrayList<SkillScheme> skillsSchemeList = response.body();

                if (skillsSchemeList == null) {
                    Toast.makeText(getActivity(), "Something wrong happened, Please try later.", Toast.LENGTH_LONG).show();
                    return;
                }
                //storePortfolioInternally();

                skillsData = skillsSchemeList;
                fillData();
                swipeContainer.setRefreshing(false);
            }

            @Override
            public void onFailure(Call<ArrayList<SkillScheme>> call, Throwable t) {

                String err = t.getMessage() == null ? "" : t.getMessage();
                Toast.makeText(getActivity(), "Service Call Failure \n" + err, Toast.LENGTH_LONG).show();
                Log.e("RETROFIT", err);
                swipeContainer.setRefreshing(false);

            }
        });
    }
}
