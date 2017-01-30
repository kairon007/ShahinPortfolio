package com.shahinjo.thingy.shahinportfolio.Fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.shahinjo.thingy.shahinportfolio.Adapters.ProfilePagerAdapter;
import com.shahinjo.thingy.shahinportfolio.Entities.GSONSchemes.ProfileScheme;
import com.shahinjo.thingy.shahinportfolio.Managers.ConstantsManager;
import com.shahinjo.thingy.shahinportfolio.R;

/**
 * Created by y.shahin on 1/29/2017.
 */

public class ProfileFragment extends Fragment {

    private FragmentActivity context;

    public ProfileFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        ViewHolder holder = new ViewHolder();

        ProfileScheme profileData = (ProfileScheme) getArguments().getSerializable(ConstantsManager.KEY_BUNDLE_PROFILE);

        holder.ivProfilePicture = (SimpleDraweeView) view.findViewById(R.id.iv_profile_picture);
        holder.tvName = (TextView) view.findViewById(R.id.tv_name);
        holder.tvPosition = (TextView) view.findViewById(R.id.tv_position);

        Uri imageUri = Uri.parse(profileData.getPiProfileImagePath());
        holder.ivProfilePicture.setImageURI(imageUri);

        holder.tvName.setText(profileData.getPiFullName());
        holder.tvPosition.setText(profileData.getPiPosition());

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_personal));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_statement));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_contact_light));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) view.findViewById(R.id.pager);
        final ProfilePagerAdapter adapter = new ProfilePagerAdapter
                (context.getSupportFragmentManager(), profileData);

        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
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
