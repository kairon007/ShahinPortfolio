package com.shahinjo.thingy.shahinportfolio.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shahinjo.thingy.shahinportfolio.Managers.ConstantsManager;
import com.shahinjo.thingy.shahinportfolio.R;

/**
 * Created by y.shahin on 1/29/2017.
 */

public class PersonalInfoFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_personal_info, container, false);
        ViewHolder holder = new ViewHolder();

        holder.tvBirthDate = (TextView) view.findViewById(R.id.tv_birth_date);
        holder.tvNationality = (TextView) view.findViewById(R.id.tv_nationality);
        holder.tvMartialState = (TextView) view.findViewById(R.id.tv_martial_state);
        holder.tvAddress = (TextView) view.findViewById(R.id.tv_address);

        String birthDate = getArguments().getString(ConstantsManager.KEY_BUNDLE_BIRTH_DATE);
        String nationality = getArguments().getString(ConstantsManager.KEY_BUNDLE_NATIONALITY);
        String martialState = getArguments().getString(ConstantsManager.KEY_BUNDLE_MARTIAL_STATE);
        String address = getArguments().getString(ConstantsManager.KEY_BUNDLE_ADDRESS);

        holder.tvBirthDate.setText(birthDate);
        holder.tvNationality.setText(nationality);
        holder.tvMartialState.setText(martialState);
        holder.tvAddress.setText(address);

        return view;
    }

    private class ViewHolder {
        TextView tvBirthDate, tvNationality, tvMartialState, tvAddress;
    }
}
