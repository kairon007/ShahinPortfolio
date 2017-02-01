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
import com.shahinjo.thingy.shahinportfolio.Adapters.ProjectsAdapter;
import com.shahinjo.thingy.shahinportfolio.Entities.GSONSchemes.EducationTrainingScheme;
import com.shahinjo.thingy.shahinportfolio.Entities.GSONSchemes.ProjectScheme;
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

public class ProjectsFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    ArrayList<ProjectScheme> projectsList;
    private Context context;
    private ListView lvProjects;
    private SwipeRefreshLayout swipeContainer;

    public ProjectsFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_projects, container, false);

        this.context = rootView.getContext();

        lvProjects = (ListView) rootView.findViewById(R.id.list_projects);
        swipeContainer = (SwipeRefreshLayout) rootView.findViewById(R.id.swipe_container);
        swipeContainer.setOnRefreshListener(this);

        projectsList = (ArrayList<ProjectScheme>) getArguments().getSerializable("projects_data");

        fillData();

        return rootView;
    }

    private void fillData() {
        if (projectsList != null) {
            lvProjects.setAdapter(new ProjectsAdapter(context, R.layout.row_project, projectsList));
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

        final Call<ArrayList<ProjectScheme>> apiCall = service.getProjectsData(1, ConstantsManager.OPERATION_PROJECTS);

        apiCall.enqueue(new Callback<ArrayList<ProjectScheme>>() {
            @Override
            public void onResponse(Call<ArrayList<ProjectScheme>> call, Response<ArrayList<ProjectScheme>> response) {

                Log.i("RETROFIT", "onResponse Called");

                ArrayList<ProjectScheme> projectsSchemeList = response.body();

                if (projectsSchemeList == null) {
                    Toast.makeText(getActivity(), "Something wrong happened, Please try later.", Toast.LENGTH_LONG).show();
                    return;
                }
                //storePortfolioInternally();

                projectsList = projectsSchemeList;
                fillData();
                swipeContainer.setRefreshing(false);
            }

            @Override
            public void onFailure(Call<ArrayList<ProjectScheme>> call, Throwable t) {

                String err = t.getMessage() == null ? "Failure" : t.getMessage();
                Toast.makeText(getActivity(), "Service Call Failure \n" + err, Toast.LENGTH_LONG).show();
                Log.e("RETROFIT", err);
                swipeContainer.setRefreshing(false);

            }
        });

    }
}
