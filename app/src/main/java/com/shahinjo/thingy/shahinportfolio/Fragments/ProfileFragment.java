package com.shahinjo.thingy.shahinportfolio.Fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.shahinjo.thingy.shahinportfolio.Activities.MainActivity;
import com.shahinjo.thingy.shahinportfolio.Adapters.ProfilePagerAdapter;
import com.shahinjo.thingy.shahinportfolio.Entities.GSONSchemes.ContactingListScheme;
import com.shahinjo.thingy.shahinportfolio.Entities.GSONSchemes.PortfolioScheme;
import com.shahinjo.thingy.shahinportfolio.Entities.GSONSchemes.ProfileScheme;
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
 * Created by y.shahin on 1/29/2017.
 */

public class ProfileFragment extends Fragment {

    ProfileScheme profileData;
    ArrayList<ContactingListScheme> contactingList;

    ProfilePagerAdapter adapter;
    private FragmentActivity context;
    private ViewHolder holder;

    public ProfileFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        holder = new ViewHolder();

        profileData = (ProfileScheme) getArguments().getSerializable(ConstantsManager.KEY_BUNDLE_PROFILE);
        contactingList = (ArrayList<ContactingListScheme>) getArguments().getSerializable(ConstantsManager.KEY_BUNDLE_CONTACT);


        onCreateViews(view);

        fillViews();

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_personal));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_statement));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_contact_light));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) view.findViewById(R.id.pager);
        adapter = new ProfilePagerAdapter
                (context.getSupportFragmentManager(), profileData, contactingList);

        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return view;
    }

    private void onCreateViews(View view) {
        holder.ivProfilePicture = (SimpleDraweeView) view.findViewById(R.id.iv_profile_picture);
        holder.tvName = (TextView) view.findViewById(R.id.tv_name);
        holder.tvPosition = (TextView) view.findViewById(R.id.tv_position);

    }

    private void fillViews() {
        Uri imageUri = Uri.parse(profileData.getPiProfileImagePath());
        holder.ivProfilePicture.setImageURI(imageUri);

        holder.tvName.setText(profileData.getPiFullName());
        holder.tvPosition.setText(profileData.getPiPosition());


    }

    private void retrievePortfolioData() {

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantsManager.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        PortfolioEndPoint service = retrofit.create(PortfolioEndPoint.class);

        final Call<PortfolioScheme> apiCall = service.getPortfolioData(1);

        apiCall.enqueue(new Callback<PortfolioScheme>() {
            @Override
            public void onResponse(Call<PortfolioScheme> call, Response<PortfolioScheme> response) {

                Log.i("RETROFIT", "onResponse Called");

                PortfolioScheme portfolioData = response.body();

                if (portfolioData == null) {
                    Toast.makeText(getActivity(), "Something wrong happened, Please try later.", Toast.LENGTH_LONG).show();
                    return;
                }

                profileData = portfolioData.getProfileScheme();

                fillViews();
            }

            @Override
            public void onFailure(Call<PortfolioScheme> call, Throwable t) {

                String err = t.getMessage() == null ? "" : t.getMessage();
                Toast.makeText(getActivity(), "Service Call Failure \n" + err, Toast.LENGTH_LONG).show();
                Log.e("RETROFIT", err);

            }
        });

    }

    @Override
    public void onAttach(Activity activity) {
        context = (FragmentActivity) activity;
        super.onAttach(activity);
    }

    private class ViewHolder {
        SimpleDraweeView ivProfilePicture;
        TextView tvName, tvPosition;

    }


}
