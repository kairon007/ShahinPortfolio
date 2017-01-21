package com.shahinjo.thingy.shahinportfolio.CustomViews;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.shahinjo.thingy.shahinportfolio.R;

/**
 * Created by shahin on 1/21/17.
 */

public class TimeLineViewHolder extends RecyclerView.ViewHolder {

    public TimelineView mTimelineView;
    TextView period;
    TextView degreeAndMajor;
    TextView location;

    public TimeLineViewHolder(View itemView, int viewType) {
        super(itemView);
        period = (TextView) itemView.findViewById(R.id.tv_period);
        mTimelineView = (TimelineView) itemView.findViewById(R.id.time_marker);
        mTimelineView.initLine(viewType);
    }

}
