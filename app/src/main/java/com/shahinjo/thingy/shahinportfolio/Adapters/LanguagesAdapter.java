package com.shahinjo.thingy.shahinportfolio.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.shahinjo.thingy.shahinportfolio.CustomViews.DoughnutView;
import com.shahinjo.thingy.shahinportfolio.Entities.GSONSchemes.LanguageScheme;
import com.shahinjo.thingy.shahinportfolio.R;

import java.util.ArrayList;

/**
 * Created by y.shahin on 1/19/2017.
 */

public class LanguagesAdapter extends BaseAdapter {

    Context context;
    LayoutInflater inflater;
    ArrayList<LanguageScheme> languagesList;

    public LanguagesAdapter(Context context, ArrayList<LanguageScheme> languagesList) {
        this.context = context;
        this.languagesList = languagesList;
        inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return languagesList.size();
    }

    @Override
    public Object getItem(int position) {
        return languagesList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = new ViewHolder();
        View cellView;

        cellView = inflater.inflate(R.layout.cell_languages, null);

        holder.doughnut = (DoughnutView) cellView.findViewById(R.id.doughnut);
        holder.tvLanguage = (TextView) cellView.findViewById(R.id.tv_name);

        float percent = 0;
        try {
            percent = Float.parseFloat(languagesList.get(position).getLStrength());
        } catch (Exception ex) {
        } finally {

            if (percent > 0)
                percent--;
        }

        holder.doughnut.animateSetPercent(percent);
        holder.tvLanguage.setText(languagesList.get(position).getLName());

        return cellView;
    }

    class ViewHolder {
        DoughnutView doughnut;
        TextView tvLanguage;
    }
}
