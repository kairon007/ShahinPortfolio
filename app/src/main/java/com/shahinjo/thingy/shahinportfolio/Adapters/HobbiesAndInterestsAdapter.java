package com.shahinjo.thingy.shahinportfolio.Adapters;

import android.content.Context;
import android.media.Image;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.shahinjo.thingy.shahinportfolio.Entities.GSONSchemes.EducationTrainingScheme;
import com.shahinjo.thingy.shahinportfolio.Entities.GSONSchemes.HobbyInterestScheme;
import com.shahinjo.thingy.shahinportfolio.R;

import java.util.ArrayList;

/**
 * Created by y.shahin on 1/19/2017.
 */

public class HobbiesAndInterestsAdapter extends BaseAdapter {


    Context context;
    LayoutInflater inflater;
    ArrayList<HobbyInterestScheme> hobbiesAndInterestsList;

    public HobbiesAndInterestsAdapter(Context context, ArrayList<HobbyInterestScheme> hobbiesAndInterestsList) {

        this.context = context;
        this.hobbiesAndInterestsList = hobbiesAndInterestsList;
        inflater = (LayoutInflater)context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return hobbiesAndInterestsList.size();
    }

    @Override
    public Object getItem(int position) {
        return hobbiesAndInterestsList.get(position);
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

        Uri imageUri = Uri.parse(hobbiesAndInterestsList.get(position).getHiImagePath());

        holder.tvTitle = (TextView) cellView.findViewById(R.id.tv_name);
        holder.ivLogo = (SimpleDraweeView) cellView.findViewById(R.id.iv_image);

        holder.tvTitle.setText(hobbiesAndInterestsList.get(position).getHiName());
        holder.ivLogo.setImageURI(imageUri);

        return cellView;
    }

    public class ViewHolder {

        SimpleDraweeView ivLogo;
        TextView tvTitle;

    }
}
