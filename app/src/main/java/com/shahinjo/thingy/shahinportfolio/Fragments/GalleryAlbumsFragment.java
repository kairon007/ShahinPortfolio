package com.shahinjo.thingy.shahinportfolio.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.shahinjo.thingy.shahinportfolio.Adapters.AlbumsAdapter;
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

public class GalleryAlbumsFragment extends Fragment implements AdapterView.OnItemClickListener, SwipeRefreshLayout.OnRefreshListener {

    private Context context;

    private ListView lvAlbumsList;
    private SwipeRefreshLayout swipeContainer;

    private ArrayList<GalleryAlbumsScheme> albumsData;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_gallery_albums, container, false);

        this.context = rootView.getContext();

        lvAlbumsList = (ListView) rootView.findViewById(R.id.lv_gallery_albums);
        swipeContainer = (SwipeRefreshLayout) rootView.findViewById(R.id.swipe_container);
        swipeContainer.setOnRefreshListener(this);

        // albumsData = (ArrayList<GalleryAlbumsScheme>) getArguments().getSerializable(ConstantsManager.KEY_BUNDLE_GALLERY_ALBUMS);

        lvAlbumsList.setOnItemClickListener(this);

        retrieveGalleryData();

        return rootView;
    }

    private void fillData() {
        if (albumsData != null) {
            lvAlbumsList.setAdapter(new AlbumsAdapter(context, R.layout.row_gallery_album, albumsData));
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

        Call<ArrayList<GalleryAlbumsScheme>> apiCall = service.getGalleryAlbumsData(1, ConstantsManager.OPERATION_GALLERY_ALBUMS);

        apiCall.enqueue(new Callback<ArrayList<GalleryAlbumsScheme>>() {
            @Override
            public void onResponse(Call<ArrayList<GalleryAlbumsScheme>> call, Response<ArrayList<GalleryAlbumsScheme>> response) {

                Log.i("RETROFIT", "onResponse Called");

                albumsData = response.body();

                if (albumsData == null) {
                    Toast.makeText(context, "Something wrong happened, Please try later.", Toast.LENGTH_LONG).show();
                    return;
                }

                fillData();
                swipeContainer.setRefreshing(false);
            }

            @Override
            public void onFailure(Call<ArrayList<GalleryAlbumsScheme>> call, Throwable t) {

                albumsData = new ArrayList<>();

                String err = t.getMessage() == null ? "Failure" : t.getMessage();
                Toast.makeText(context, "Service Call Failure \n" + err, Toast.LENGTH_LONG).show();
                Log.e("RETROFIT", t.getMessage());

                fillData();
                swipeContainer.setRefreshing(false);
            }
        });

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        GalleryAlbumsScheme currentAlbum = albumsData.get(position);
        String gaId = currentAlbum.getGaId();


        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        AlbumImagesFragment albumFragment = new AlbumImagesFragment();

        Bundle galleryBundle = new Bundle();

        galleryBundle.putString(ConstantsManager.KEY_BUNDLE_ALBUM_ID, gaId);

        albumFragment.setArguments(galleryBundle);

        fragmentTransaction.addToBackStack("xyz");

        fragmentTransaction.hide(GalleryAlbumsFragment.this);
        fragmentTransaction.add(R.id.content_main, albumFragment);
        fragmentTransaction.commit();

    }

    @Override
    public void onRefresh() {
        retrieveGalleryData();
    }
}
