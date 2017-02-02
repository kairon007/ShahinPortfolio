package com.shahinjo.thingy.shahinportfolio.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shahinjo.thingy.shahinportfolio.Managers.ConstantsManager;
import com.shahinjo.thingy.shahinportfolio.Managers.TextManager;
import com.shahinjo.thingy.shahinportfolio.R;

/**
 * Created by y.shahin on 1/29/2017.
 */

public class PersonalStatementFragment extends Fragment {

    ViewHolder holder;
    String personalStatement;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_personal_statement, container, false);
        holder = new ViewHolder();

        holder.tvPersonalStatement = (TextView) view.findViewById(R.id.tv_personal_statement);

        refresh();

        return view;
    }

    private void fillViews() {
        holder.tvPersonalStatement.setText(TextManager.removeBreakLinCharacters(personalStatement));
    }

    public void refresh() {
        personalStatement = getArguments().getString(ConstantsManager.KEY_BUNDLE_PERSONAL_STATEMENT);

        fillViews();
    }

    private class ViewHolder {
        TextView tvPersonalStatement;
    }


}
