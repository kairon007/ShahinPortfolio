package com.shahinjo.thingy.shahinportfolio.Activities;

import android.content.Intent;
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
import com.shahinjo.thingy.shahinportfolio.Entities.GSONSchemes.EducationTrainingScheme;
import com.shahinjo.thingy.shahinportfolio.Entities.GSONSchemes.HobbyInterestScheme;
import com.shahinjo.thingy.shahinportfolio.Entities.GSONSchemes.LanguageScheme;
import com.shahinjo.thingy.shahinportfolio.Entities.GSONSchemes.PortfolioScheme;
import com.shahinjo.thingy.shahinportfolio.Entities.GSONSchemes.ProjectScheme;
import com.shahinjo.thingy.shahinportfolio.Entities.GSONSchemes.SkillScheme;
import com.shahinjo.thingy.shahinportfolio.Entities.GSONSchemes.WorkExperienceScheme;
import com.shahinjo.thingy.shahinportfolio.Fragments.AboutMeFragment;
import com.shahinjo.thingy.shahinportfolio.Fragments.EducationAndTrainingFragment;
import com.shahinjo.thingy.shahinportfolio.Fragments.HobbiesAndInterestsFragment;
import com.shahinjo.thingy.shahinportfolio.Fragments.LanguagesFragment;
import com.shahinjo.thingy.shahinportfolio.Fragments.ProfileFragment;
import com.shahinjo.thingy.shahinportfolio.Fragments.ProjectsFragment;
import com.shahinjo.thingy.shahinportfolio.Fragments.SkillsFragment;
import com.shahinjo.thingy.shahinportfolio.Fragments.WorkExperienceFragment;
import com.shahinjo.thingy.shahinportfolio.Managers.ConstantsManager;
import com.shahinjo.thingy.shahinportfolio.Managers.InternalStorageManager;
import com.shahinjo.thingy.shahinportfolio.Managers.PortfolioEndPoint;
import com.shahinjo.thingy.shahinportfolio.R;

import java.util.ArrayList;
import java.util.Collection;

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
    FragmentManager fragmentManager;

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

        fragmentManager = getSupportFragmentManager();


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

                if (portfolioData == null) {
                    Toast.makeText(MainActivity.this, "Something wrong happened, Please try later.", Toast.LENGTH_LONG).show();
                    return;
                }
                storePortfolioInternally();

                Fragment fragment = new ProfileFragment();

                Bundle profileBundle = new Bundle();

                if (portfolioData != null) {
                    profileBundle.putSerializable(ConstantsManager.KEY_BUNDLE_PROFILE, portfolioData.getProfileScheme());

                    fragment.setArguments(profileBundle);
                }

                fragmentManager.beginTransaction().replace(R.id.ll_fragment_contents, fragment).commit();

                //String message = String.format("Welcom %s \n %s", portfolioData.getProfileScheme().getPiFullName(), portfolioData.getProfileScheme().getPiPosition());
                //Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();


            }

            @Override
            public void onFailure(Call<PortfolioScheme> call, Throwable t) {

                String err = t.getMessage() == null ? "Failure" : t.getMessage();
                Toast.makeText(MainActivity.this, "Service Call Failure \n" + err, Toast.LENGTH_LONG).show();
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
        } else if (id == R.id.action_reload) {

            retrievePortfolioData();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        fragmentManager = getSupportFragmentManager();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        int id = item.getItemId();

        Fragment fragment = null;

        if (id == R.id.nav_about_me) {
            fragment = new ProfileFragment();

            Bundle profileBundle = new Bundle();

            if (portfolioData != null) {
                profileBundle.putSerializable(ConstantsManager.KEY_BUNDLE_PROFILE, portfolioData.getProfileScheme());

                fragment.setArguments(profileBundle);
            }

        } else if (id == R.id.nav_education_and_training) {
            fragment = new EducationAndTrainingFragment();

            Bundle educationBundle = new Bundle();

            if (portfolioData != null) {
                ArrayList<EducationTrainingScheme> educationList = new ArrayList<>(portfolioData.getEducationTrainingScheme());

                educationBundle.putSerializable(ConstantsManager.KEY_BUNDLE_EDUCATION, educationList);

                fragment.setArguments(educationBundle);
            }

        } else if (id == R.id.nav_work_experience) {
            fragment = new WorkExperienceFragment();

            Bundle workExperienceBundle = new Bundle();

            if (portfolioData != null) {
                ArrayList<WorkExperienceScheme> workExperienceList = new ArrayList<>(portfolioData.getWorkExperienceScheme());
                //Collections.reverse(workExperienceList);
                workExperienceBundle.putSerializable(ConstantsManager.KEY_BUNDLE_WORK_EXPERIENCE, workExperienceList);

                fragment.setArguments(workExperienceBundle);
            }

        } else if (id == R.id.nav_projects) {
            fragment = new ProjectsFragment();

            Bundle projectsBundle = new Bundle();

            if (portfolioData != null) {
                ArrayList<ProjectScheme> projectsList = new ArrayList<>(portfolioData.getProjectScheme());
                projectsBundle.putSerializable(ConstantsManager.KEY_BUNDLE_PROJECTS, projectsList);

                fragment.setArguments(projectsBundle);

            }

        } else if (id == R.id.nav_skills) {
            fragment = new SkillsFragment();

            Bundle skillsBundle = new Bundle();

            if (portfolioData != null) {
                ArrayList<SkillScheme> skillsList = new ArrayList<>(portfolioData.getSkillScheme());
                skillsBundle.putSerializable(ConstantsManager.KEY_BUNDLE_SKILLS, skillsList);

                fragment.setArguments(skillsBundle);

            }

        } else if (id == R.id.nav_languages) {
            fragment = new LanguagesFragment();

            Bundle languagesBundle = new Bundle();

            if (portfolioData != null) {
                ArrayList<LanguageScheme> languagesList = new ArrayList<>(portfolioData.getLanguageScheme());
                languagesBundle.putSerializable(ConstantsManager.KEY_BUNDLE_LANGUAGES, languagesList);

                fragment.setArguments(languagesBundle);

            }

        } else if (id == R.id.nav_hobbies_and_interests) {
            fragment = new HobbiesAndInterestsFragment();

            Bundle hobbiesBundle = new Bundle();

            if (portfolioData != null) {
                ArrayList<HobbyInterestScheme> hobbiesInterestsList = new ArrayList<>(portfolioData.getHobbyInterestScheme());
                hobbiesBundle.putSerializable(ConstantsManager.KEY_BUNDLE_HOBBIES_INTERESTS, hobbiesInterestsList);

                fragment.setArguments(hobbiesBundle);
            }

        } else if (id == R.id.nav_share) {
            try {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_SUBJECT, "Shahin's Portfolio");
                String sAux = "\nLet me recommend you this application\n\n";
                sAux = sAux + "https://play.google.com/store/apps/details?id=com.shahinjo.thingy.shahinportfolio \n\n";
                i.putExtra(Intent.EXTRA_TEXT, sAux);
                startActivity(Intent.createChooser(i, "choose one"));
            } catch (Exception e) {
                e.printStackTrace();
            }

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
