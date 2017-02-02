package com.shahinjo.thingy.shahinportfolio.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shahinjo.thingy.shahinportfolio.R;

/**
 * Created by y.shahin on 1/29/2017.
 */

public class ContactInformationFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact_information, container, false);


        return view;
    }

    public void refresh() {

    }
}
