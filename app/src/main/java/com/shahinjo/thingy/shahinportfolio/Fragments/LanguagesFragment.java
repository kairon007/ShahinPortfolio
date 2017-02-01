package com.shahinjo.thingy.shahinportfolio.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.shahinjo.thingy.shahinportfolio.Adapters.LanguagesAdapter;
import com.shahinjo.thingy.shahinportfolio.Entities.GSONSchemes.EducationTrainingScheme;
import com.shahinjo.thingy.shahinportfolio.Entities.GSONSchemes.LanguageScheme;
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

public class LanguagesFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    ArrayList<LanguageScheme> languagesList;
    private Context context;
    private GridView gridView;
    private SwipeRefreshLayout swipeContainer;


    public LanguagesFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_languages, container, false);

        this.context = rootView.getContext();

        gridView = (GridView) rootView.findViewById(R.id.grid_languages);
        swipeContainer = (SwipeRefreshLayout) rootView.findViewById(R.id.swipe_container);
        swipeContainer.setOnRefreshListener(this);

        languagesList = (ArrayList<LanguageScheme>) getArguments().getSerializable("languages_data");

        fillData();

        return rootView;
    }

    private void fillData() {
        if (languagesList != null) {
            gridView.setAdapter(new LanguagesAdapter(context, languagesList));
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

        final Call<ArrayList<LanguageScheme>> apiCall = service.getLanguagesData(1, ConstantsManager.OPERATION_LANGUAGES);

        apiCall.enqueue(new Callback<ArrayList<LanguageScheme>>() {
            @Override
            public void onResponse(Call<ArrayList<LanguageScheme>> call, Response<ArrayList<LanguageScheme>> response) {

                Log.i("RETROFIT", "onResponse Called");

                ArrayList<LanguageScheme> languagesSchemeList = response.body();

                if (languagesSchemeList == null) {
                    Toast.makeText(getActivity(), "Something wrong happened, Please try later.", Toast.LENGTH_LONG).show();
                    return;
                }
                //storePortfolioInternally();

                languagesList = languagesSchemeList;
                fillData();
                swipeContainer.setRefreshing(false);
            }

            @Override
            public void onFailure(Call<ArrayList<LanguageScheme>> call, Throwable t) {

                String err = t.getMessage() == null ? "Failure" : t.getMessage();
                Toast.makeText(getActivity(), "Service Call Failure \n" + err, Toast.LENGTH_LONG).show();
                Log.e("RETROFIT", err);
                swipeContainer.setRefreshing(false);

            }
        });
    }
}
