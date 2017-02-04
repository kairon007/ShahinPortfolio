package com.shahinjo.thingy.shahinportfolio.Adapters;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.shahinjo.thingy.shahinportfolio.Entities.GSONSchemes.AlbumImagesScheme;
import com.shahinjo.thingy.shahinportfolio.R;

import java.util.ArrayList;

/**
 * Created by y.shahin on 2/4/2017.
 */

public class GalleryImagesAdapter extends RecyclerView.Adapter<GalleryImagesAdapter.ViewHolder> {

    Context context;

    ArrayList<AlbumImagesScheme> galleryData;

    public GalleryImagesAdapter(Context context, ArrayList<AlbumImagesScheme> galleryData) {
        this.galleryData = galleryData;
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_gallery_image, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvTitle.setText(galleryData.get(position).getAiImageTitle());
        Uri imageUri = Uri.parse(galleryData.get(position).getAiImageUrl());
        holder.ivImage.setImageURI(imageUri);
    }

    @Override
    public int getItemCount() {
        return galleryData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTitle;
        private SimpleDraweeView ivImage;

        public ViewHolder(View view) {
            super(view);

            tvTitle = (TextView) view.findViewById(R.id.tv_name);
            ivImage = (SimpleDraweeView) view.findViewById(R.id.iv_image);
        }
    }

}
