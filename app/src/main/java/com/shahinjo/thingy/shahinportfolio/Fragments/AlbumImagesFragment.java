package com.shahinjo.thingy.shahinportfolio.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.shahinjo.thingy.shahinportfolio.Adapters.AlbumsAdapter;
import com.shahinjo.thingy.shahinportfolio.Adapters.GalleryImagesAdapter;
import com.shahinjo.thingy.shahinportfolio.Entities.GSONSchemes.AlbumImagesScheme;
import com.shahinjo.thingy.shahinportfolio.Entities.GSONSchemes.GalleryAlbumsScheme;
import com.shahinjo.thingy.shahinportfolio.Managers.ConstantsManager;
import com.shahinjo.thingy.shahinportfolio.Managers.PortfolioEndPoint;
import com.shahinjo.thingy.shahinportfolio.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by y.shahin on 2/4/2017.
 */

public class AlbumImagesFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    Context context;

    ArrayList<AlbumImagesScheme> imagesData;
    int albumID;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    private SwipeRefreshLayout swipeContainer;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_album_images, container, false);

        this.context = rootView.getContext();

        swipeContainer = (SwipeRefreshLayout) rootView.findViewById(R.id.swipe_container);
        swipeContainer.setOnRefreshListener(this);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.image_gallery);
        recyclerView.setHasFixedSize(true);

        layoutManager = new GridLayoutManager(context, 2);
        recyclerView.setLayoutManager(layoutManager);

        albumID = Integer.parseInt(getArguments().getString(ConstantsManager.KEY_BUNDLE_ALBUM_ID));

        retrieveGalleryData();

        return rootView;
    }

    private void fillData() {
        if (imagesData != null) {

            GalleryImagesAdapter adapter = new GalleryImagesAdapter(context, imagesData);
            recyclerView.setAdapter(adapter);

        }
    }

    private void retrieveGalleryData() {

        swipeContainer.setRefreshing(true);

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantsManager.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        PortfolioEndPoint service = retrofit.create(PortfolioEndPoint.class);

        Call<ArrayList<AlbumImagesScheme>> apiCall = service.getAlbumImagesData(1, ConstantsManager.OPERATION_ALBUM_IMAGES, albumID);

        apiCall.enqueue(new Callback<ArrayList<AlbumImagesScheme>>() {
            @Override
            public void onResponse(Call<ArrayList<AlbumImagesScheme>> call, Response<ArrayList<AlbumImagesScheme>> response) {

                Log.i("RETROFIT", "onResponse Called");

                imagesData = response.body();

                if (imagesData == null) {
                    Toast.makeText(context, "Something wrong happened, Please try later.", Toast.LENGTH_LONG).show();
                    return;
                }

                fillData();
                swipeContainer.setRefreshing(false);
            }

            @Override
            public void onFailure(Call<ArrayList<AlbumImagesScheme>> call, Throwable t) {

                imagesData = new ArrayList<>();

                String err = t.getMessage() == null ? "Failure" : t.getMessage();
                Toast.makeText(context, "Service Call Failure \n" + err, Toast.LENGTH_LONG).show();
                Log.e("RETROFIT", t.getMessage());

                fillData();
                swipeContainer.setRefreshing(false);
            }
        });

    }

    @Override
    public void onRefresh() {
        retrieveGalleryData();
    }
}
