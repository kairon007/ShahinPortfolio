package com.shahinjo.thingy.shahinportfolio.Adapters;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.shahinjo.thingy.shahinportfolio.Entities.GSONSchemes.ContactingListScheme;
import com.shahinjo.thingy.shahinportfolio.R;

import java.util.ArrayList;

/**
 * Created by y.shahin on 2/2/2017.
 */

public class ContactingAdapter extends ArrayAdapter<ContactingListScheme> {

    Context context;
    ArrayList<ContactingListScheme> contactingData;

    public ContactingAdapter(Context context, int resource, ArrayList<ContactingListScheme> contactingData) {
        super(context, resource, contactingData);
        this.contactingData = contactingData;
        this.context = context;

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        ContactingListScheme currentContacting = contactingData.get(position);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        if (convertView == null) {

            convertView = inflater.inflate(R.layout.row_contact, null);
            holder = new ViewHolder();

            holder.tvContactValue = (TextView) convertView.findViewById(R.id.tv_contact_value);
            holder.ivContactImage = (SimpleDraweeView) convertView.findViewById(R.id.iv_contact_image);

            holder.tvContactValue.setText(currentContacting.getPciValue());
            Uri imageUri = Uri.parse(currentContacting.getCtIcon());
            holder.ivContactImage.setImageURI(imageUri);

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
        SimpleDraweeView ivContactImage;
        TextView tvContactValue;
    }
}
