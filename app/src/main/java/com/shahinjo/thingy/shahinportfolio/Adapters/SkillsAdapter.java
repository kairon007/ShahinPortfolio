package com.shahinjo.thingy.shahinportfolio.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import com.shahinjo.thingy.shahinportfolio.Entities.GSONSchemes.SkillScheme;
import com.shahinjo.thingy.shahinportfolio.R;

import java.util.ArrayList;

/**
 * Created by shahin on 1/21/17.
 */

public class SkillsAdapter extends ArrayAdapter<SkillScheme> {

    Context context;
    ArrayList<SkillScheme> skillsData;

    public SkillsAdapter(Context context, int resource, ArrayList<SkillScheme> skillsData) {
        super(context, resource, skillsData);
        this.skillsData = skillsData;
        this.context = context;

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        SkillScheme currentSkill = skillsData.get(position);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        if (convertView == null) {

            convertView = inflater.inflate(R.layout.row_skill, null);
            holder = new ViewHolder();

            holder.tvSkill = (TextView) convertView.findViewById(R.id.tv_skill);
            holder.ratingBar = (RatingBar) convertView.findViewById(R.id.ratingBar);

            holder.tvSkill.setText(currentSkill.getSName());
            int strength = 0;
            try {
                strength = Integer.parseInt(currentSkill.getSStrength());
            } catch (Exception ex) {

            }
            holder.ratingBar.setNumStars(8);
            holder.ratingBar.setRating(strength);


            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        /*holder.tvName.setText(currentProject.getPName());
        holder.tvDescription.setText(currentProject.getPDescription());
        holder.tvTeam.setText(currentProject.getPTeamCompany());*/

        return convertView;
    }

    class ViewHolder {
        TextView tvSkill;
        RatingBar ratingBar;
    }
}
