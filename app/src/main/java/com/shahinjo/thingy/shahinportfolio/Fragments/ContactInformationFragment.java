package com.shahinjo.thingy.shahinportfolio.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.shahinjo.thingy.shahinportfolio.Adapters.ContactingAdapter;
import com.shahinjo.thingy.shahinportfolio.Entities.GSONSchemes.ContactingListScheme;
import com.shahinjo.thingy.shahinportfolio.Managers.ConstantsManager;
import com.shahinjo.thingy.shahinportfolio.R;

import java.util.ArrayList;

/**
 * Created by y.shahin on 1/29/2017.
 */

public class ContactInformationFragment extends Fragment implements AdapterView.OnItemClickListener {

    private Context context;
    private ListView lvContactingList;

    private ArrayList<ContactingListScheme> contactingData;

    public static Intent getOpenFacebookIntent(Context context, String url, String id) {

        try {
            context.getPackageManager()
                    .getPackageInfo("com.facebook.katana", 0); //Checks if FB is even installed.
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("fb://profile/" + id)); //Trys to make intent with FB's URI
        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse(url)); //catches and opens a url to the desired page
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_contact_information, container, false);

        this.context = rootView.getContext();

        lvContactingList = (ListView) rootView.findViewById(R.id.lv_contacting_list);

        contactingData = (ArrayList<ContactingListScheme>) getArguments().getSerializable(ConstantsManager.KEY_BUNDLE_CONTACT);

        lvContactingList.setOnItemClickListener(this);

        fillData();

        return rootView;
    }

    private void fillData() {
        if (contactingData != null) {
            lvContactingList.setAdapter(new ContactingAdapter(context, R.layout.row_contact, contactingData));
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ContactingListScheme currentContact = contactingData.get(position);

        int contactTypeID = Integer.parseInt(currentContact.getCtId());
        String contactType = currentContact.getCtName();

        if (contactType.toLowerCase().equals("phone") || contactType.toLowerCase().equals("mobile")) {

            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse(String.format("tel:%s", currentContact.getPciValue())));
            startActivity(intent);

        } else if (contactType.toLowerCase().equals("facebook")) {

            /**
             * ID retreived From http://findmyfbid.com/
             */
            Intent facebookIntent = getOpenFacebookIntent(context, "https://www.facebook.com/usifshahin.91", "100003850029102");
            startActivity(facebookIntent);

        } else if (contactType.toLowerCase().equals("")) {

        } else if (contactType.toLowerCase().equals("")) {

        } else if (contactType.toLowerCase().equals("")) {

        } else if (contactType.toLowerCase().equals("")) {

        } else if (contactType.toLowerCase().equals("")) {

        } else if (contactType.toLowerCase().equals("")) {

        } else if (contactType.toLowerCase().equals("")) {

        } else if (contactType.toLowerCase().equals("")) {

        }

    }
}
