package com.shahinjo.thingy.shahinportfolio.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shahinjo.thingy.shahinportfolio.R;

/**
 * Created by y.shahin on 1/18/2017.
 */

public class AboutMeFragment extends Fragment {


    public AboutMeFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_about_me,container, false);
        

        return rootView;
    }
}
