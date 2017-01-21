package com.shahinjo.thingy.shahinportfolio.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.shahinjo.thingy.shahinportfolio.Entities.GSONSchemes.ProjectScheme;
import com.shahinjo.thingy.shahinportfolio.R;

import java.util.ArrayList;

/**
 * Created by shahin on 1/21/17.
 */

public class ProjectsAdapter extends ArrayAdapter<ProjectScheme> {

    Context context;
    ArrayList<ProjectScheme> projectsData;

    public ProjectsAdapter(Context context, int resource, ArrayList<ProjectScheme> projectsData) {
        super(context, resource, projectsData);
        this.context = context;
        this.projectsData = projectsData;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        ProjectScheme currentProject = projectsData.get(position);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        if (convertView == null) {

            convertView = inflater.inflate(R.layout.row_project, null);
            holder = new ViewHolder();

            holder.ivImage = (ImageView) convertView.findViewById(R.id.iv_image);
            holder.tvDescription = (TextView) convertView.findViewById(R.id.tv_description);
            holder.tvName = (TextView) convertView.findViewById(R.id.tv_name);
            holder.tvTeam = (TextView) convertView.findViewById(R.id.tv_team);

            holder.tvName.setText(currentProject.getPName());
            holder.tvDescription.setText(currentProject.getPDescription());
            holder.tvTeam.setText(currentProject.getPTeamCompany());

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

        ImageView ivImage;
        TextView tvName;
        TextView tvDescription;
        TextView tvTeam;

    }
}
