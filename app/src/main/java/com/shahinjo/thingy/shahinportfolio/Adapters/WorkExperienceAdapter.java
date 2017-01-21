package com.shahinjo.thingy.shahinportfolio.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.shahinjo.thingy.shahinportfolio.Entities.GSONSchemes.WorkExperienceScheme;
import com.shahinjo.thingy.shahinportfolio.R;

import java.util.ArrayList;

/**
 * Created by y.shahin on 1/19/2017.
 */

public class WorkExperienceAdapter extends BaseAdapter {

    Context context;
    LayoutInflater inflater;
    ArrayList<WorkExperienceScheme> workExperienceList;

    public WorkExperienceAdapter(Context context, ArrayList<WorkExperienceScheme> workExperienceList) {
        this.context = context;
        this.workExperienceList = workExperienceList;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return workExperienceList.size();
    }

    @Override
    public Object getItem(int position) {
        return workExperienceList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = new ViewHolder();
        View cellView;

        cellView = inflater.inflate(R.layout.cell_work_experience, null);

        holder.tvYearsCount = (TextView) cellView.findViewById(R.id.tv_years_count);
        holder.tvPosition = (TextView) cellView.findViewById(R.id.tv_position);
        holder.tvPeriod = (TextView) cellView.findViewById(R.id.tv_period);
        holder.tvLocation = (TextView) cellView.findViewById(R.id.tv_location);

        String period = String.format("%s  -  %s", workExperienceList.get(position).getWeFrom(), workExperienceList.get(position).getWeTo());

        holder.tvYearsCount.setText(workExperienceList.get(position).getWeYears());
        holder.tvPosition.setText(workExperienceList.get(position).getWePosition());
        holder.tvPeriod.setText(period);
        holder.tvLocation.setText(workExperienceList.get(position).getWeCompanyOrTeam());


        return cellView;
    }

    public class ViewHolder {

        TextView tvYearsCount;
        TextView tvPosition;
        TextView tvPeriod;
        TextView tvLocation;

    }
}
