package com.shahinjo.thingy.shahinportfolio.Activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.shahinjo.thingy.shahinportfolio.Entities.GSONSchemes.HobbyInterestScheme;
import com.shahinjo.thingy.shahinportfolio.Entities.GSONSchemes.PortfolioScheme;
import com.shahinjo.thingy.shahinportfolio.Fragments.AboutMeFragment;
import com.shahinjo.thingy.shahinportfolio.Fragments.EducationAndTrainingFragment;
import com.shahinjo.thingy.shahinportfolio.Fragments.HobbiesAndInterestsFragment;
import com.shahinjo.thingy.shahinportfolio.Fragments.LanguagesFragment;
import com.shahinjo.thingy.shahinportfolio.Fragments.ProjectsFragment;
import com.shahinjo.thingy.shahinportfolio.Fragments.SkillsFragment;
import com.shahinjo.thingy.shahinportfolio.Fragments.WorkExperienceFragment;
import com.shahinjo.thingy.shahinportfolio.Managers.ConstantsManager;
import com.shahinjo.thingy.shahinportfolio.Managers.InternalStorageManager;
import com.shahinjo.thingy.shahinportfolio.Managers.PortfolioEndPoint;
import com.shahinjo.thingy.shahinportfolio.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    PortfolioScheme portfolioData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Comment action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



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

                portfolioData = response.body();

                storePortfolioInternally();

                String message = String.format("Welcom %s \n %s", portfolioData.getProfileScheme().getPiFullName(), portfolioData.getProfileScheme().getPiPosition());
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();


            }

            @Override
            public void onFailure(Call<PortfolioScheme> call, Throwable t) {

                Toast.makeText(MainActivity.this, "Service Call Failure \n" + t.getMessage(), Toast.LENGTH_LONG).show();
                Log.e("RETROFIT", t.getMessage());

            }
        });

    }

    private void storePortfolioInternally() {
        InternalStorageManager.writePortfolioListToFile(MainActivity.this, ConstantsManager.FILE_NAME_PORTFOLIO, portfolioData);
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (portfolioData == null) {

//            Object object = InternalStorageManager.readPortfolioListFromFile(MainActivity.this, ConstantsManager.FILE_NAME_PORTFOLIO);
//
//            if (object != null) {
//                portfolioData = (PortfolioScheme) object;
//            } else {
//                retrievePortfolioData();
//            }

            retrievePortfolioData();

        }

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        FragmentManager fragmentManager = getSupportFragmentManager();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        int id = item.getItemId();

        Fragment fragment = null;
        if (id == R.id.nav_about_me) {
            fragment = new AboutMeFragment();

            Bundle profileBundle = new Bundle();
            profileBundle.putSerializable("profile_data", portfolioData.getProfileScheme());

            fragment.setArguments(profileBundle);


        } else if (id == R.id.nav_education_and_training) {
            fragment = new EducationAndTrainingFragment();

        } else if (id == R.id.nav_work_experience) {
            fragment = new WorkExperienceFragment();

        } else if (id == R.id.nav_projects) {
            fragment = new ProjectsFragment();

        } else if (id == R.id.nav_skills) {
            fragment = new SkillsFragment();

        } else if (id == R.id.nav_languages) {
            fragment = new LanguagesFragment();

        } else if (id == R.id.nav_hobbies_and_interests) {
            fragment = new HobbiesAndInterestsFragment();

            Bundle hobbiesBundle = new Bundle();
            ArrayList<HobbyInterestScheme> hobbiesInterestsList = new ArrayList<>(portfolioData.getHobbyInterestScheme());
            hobbiesBundle.putSerializable("hobbies_interests_data", hobbiesInterestsList);

            fragment.setArguments(hobbiesBundle);

        } else if (id == R.id.nav_share) {
            //fragment = new AboutMeFragment();

        } else if (id == R.id.nav_blog) {
            //fragment = new AboutMeFragment();
        }

        if (fragment == null) {
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }

        fragmentManager.beginTransaction().replace(R.id.ll_fragment_contents, fragment).commit();


        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
