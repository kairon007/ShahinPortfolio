package com.shahinjo.thingy.shahinportfolio.Adapters;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.shahinjo.thingy.shahinportfolio.Entities.GSONSchemes.GalleryAlbumsScheme;
import com.shahinjo.thingy.shahinportfolio.R;

import java.util.ArrayList;

/**
 * Created by y.shahin on 2/4/2017.
 */

public class AlbumsAdapter extends ArrayAdapter<GalleryAlbumsScheme> {

    Context context;
    ArrayList<GalleryAlbumsScheme> albumsData;

    public AlbumsAdapter(Context context, int resource, ArrayList<GalleryAlbumsScheme> albumsData) {
        super(context, resource, albumsData);
        this.albumsData = albumsData;
        this.context = context;

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        GalleryAlbumsScheme currentAlbum = albumsData.get(position);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        if (convertView == null) {

            convertView = inflater.inflate(R.layout.row_gallery_album, null);
            holder = new ViewHolder();

            holder.tvAlbumTitle = (TextView) convertView.findViewById(R.id.tv_album_title);
            holder.ivAlbumImage = (SimpleDraweeView) convertView.findViewById(R.id.iv_album_image);

            holder.tvAlbumTitle.setText(currentAlbum.getGaName());
            Uri imageUri = Uri.parse(currentAlbum.getGaThumbnailUrl());
            holder.ivAlbumImage.setImageURI(imageUri);

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();

        }

        return convertView;
    }

    class ViewHolder {
        SimpleDraweeView ivAlbumImage;
        TextView tvAlbumTitle;
    }

}
