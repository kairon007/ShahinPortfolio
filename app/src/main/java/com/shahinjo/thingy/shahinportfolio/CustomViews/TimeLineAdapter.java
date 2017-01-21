package com.shahinjo.thingy.shahinportfolio.CustomViews;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shahinjo.thingy.shahinportfolio.R;

import java.util.ArrayList;

/**
 * Created by shahin on 1/21/17.
 */

public class TimeLineAdapter extends RecyclerView.Adapter<TimeLineViewHolder> {

    private ArrayList<TimeLineModel> timeLineData;
    private Context context;
    private Orientation orientation;


    public TimeLineAdapter(Context context, ArrayList<TimeLineModel> timeLineData, Orientation orientation) {

        this.context = context;
        this.timeLineData = timeLineData;
        this.orientation = orientation;
    }

    @Override
    public TimeLineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;

        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_education_timeline, parent, false);

        /*if(orientation == Orientation.horizontal) {
            view = View.inflate(parent.getContext(), R.layout.item_education_timeline_horizontal, null);
        } else {
            view = View.inflate(parent.getContext(), R.layout.item_education_timeline, null);
        }*/

        return new TimeLineViewHolder(view, viewType);
    }

    @Override
    public void onBindViewHolder(TimeLineViewHolder holder, int position) {

        TimeLineModel timeLineModel = timeLineData.get(position);

        holder.period.setText(timeLineModel.getPeriod());
        holder.degreeAndMajor.setText(String.format("%s, in %s", timeLineModel.getDegree(), timeLineModel.getMajor()));
        holder.location.setText(timeLineModel.getLocation());

    }

    @Override
    public int getItemCount() {

        return timeLineData.size();
    }
}
