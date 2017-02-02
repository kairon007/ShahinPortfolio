package com.shahinjo.thingy.shahinportfolio.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.shahinjo.thingy.shahinportfolio.Adapters.ContactingAdapter;
import com.shahinjo.thingy.shahinportfolio.Entities.GSONSchemes.ContactingListScheme;
import com.shahinjo.thingy.shahinportfolio.Managers.ConstantsManager;
import com.shahinjo.thingy.shahinportfolio.R;

import java.util.ArrayList;

/**
 * Created by y.shahin on 1/29/2017.
 */

public class ContactInformationFragment extends Fragment {

    private Context context;
    private ListView lvContactingList;

    private ArrayList<ContactingListScheme> contactingData;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_contact_information, container, false);

        this.context = rootView.getContext();

        lvContactingList = (ListView) rootView.findViewById(R.id.lv_contacting_list);

        contactingData = (ArrayList<ContactingListScheme>) getArguments().getSerializable(ConstantsManager.KEY_BUNDLE_CONTACT);

        fillData();

        return rootView;
    }

    private void fillData() {
        if (contactingData != null) {
            lvContactingList.setAdapter(new ContactingAdapter(context, R.layout.row_contact, contactingData));
        }
    }
}
