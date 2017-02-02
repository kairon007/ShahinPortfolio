package com.shahinjo.thingy.shahinportfolio.Adapters;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.shahinjo.thingy.shahinportfolio.Entities.GSONSchemes.ProjectScheme;
import com.shahinjo.thingy.shahinportfolio.Managers.TextManager;
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

            Uri imageUri = Uri.parse(currentProject.getPImagePath());

            holder.ivImage = (SimpleDraweeView) convertView.findViewById(R.id.iv_image);
            holder.tvDescription = (TextView) convertView.findViewById(R.id.tv_description);
            holder.tvName = (TextView) convertView.findViewById(R.id.tv_name);
            holder.tvTeam = (TextView) convertView.findViewById(R.id.tv_team);
            holder.ivImage = (SimpleDraweeView) convertView.findViewById(R.id.iv_image);

            holder.tvName.setText(TextManager.removeBreakLinCharacters(currentProject.getPName()));
            holder.tvDescription.setText(TextManager.removeBreakLinCharacters(currentProject.getPDescription()));
            holder.tvTeam.setText(TextManager.removeBreakLinCharacters(currentProject.getPTeamCompany()));
            holder.ivImage.setImageURI(imageUri);

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        return convertView;
    }
    class ViewHolder {

        SimpleDraweeView ivImage;
        TextView tvName;
        TextView tvDescription;
        TextView tvTeam;

    }
}
