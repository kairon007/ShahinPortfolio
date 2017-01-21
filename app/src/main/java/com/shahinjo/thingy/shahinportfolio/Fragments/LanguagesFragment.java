package com.shahinjo.thingy.shahinportfolio.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.shahinjo.thingy.shahinportfolio.Adapters.LanguagesAdapter;
import com.shahinjo.thingy.shahinportfolio.Entities.GSONSchemes.LanguageScheme;
import com.shahinjo.thingy.shahinportfolio.R;

import java.util.ArrayList;

/**
 * Created by shahin on 1/19/17.
 */

public class LanguagesFragment extends Fragment {

    public LanguagesFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_languages, container, false);
        GridView gridView = (GridView) rootView.findViewById(R.id.grid_languages);

        ArrayList<LanguageScheme> languagesList = (ArrayList<LanguageScheme>) getArguments().getSerializable("languages_data");

        if (languagesList != null) {
            gridView.setAdapter(new LanguagesAdapter(rootView.getContext(), languagesList));
        }

        return rootView;
    }

}
