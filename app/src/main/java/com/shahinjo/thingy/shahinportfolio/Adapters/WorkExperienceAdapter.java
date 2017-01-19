package com.shahinjo.thingy.shahinportfolio.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.shahinjo.thingy.shahinportfolio.Entities.GSONSchemes.HobbyInterestScheme;
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

    public class ViewHolder {

        TextView tvYearsCount;
        TextView tvTitle;
        TextView tvPeriod;
        TextView tvLocation;

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

        cellView = inflater.inflate(R.layout.cell_hobbies_and_interests, null);

//        holder.tvTitle = (TextView) cellView.findViewById(R.id.tv_name);
//        holder.ivLogo = (ImageView) cellView.findViewById(R.id.iv_image);




        return null;
    }
}
