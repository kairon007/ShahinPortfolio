package com.shahinjo.thingy.shahinportfolio.Managers;

import com.shahinjo.thingy.shahinportfolio.Entities.GSONSchemes.EducationTrainingScheme;
import com.shahinjo.thingy.shahinportfolio.Entities.GSONSchemes.HobbyInterestScheme;
import com.shahinjo.thingy.shahinportfolio.Entities.GSONSchemes.LanguageScheme;
import com.shahinjo.thingy.shahinportfolio.Entities.GSONSchemes.PortfolioScheme;
import com.shahinjo.thingy.shahinportfolio.Entities.GSONSchemes.ProjectScheme;
import com.shahinjo.thingy.shahinportfolio.Entities.GSONSchemes.SkillScheme;
import com.shahinjo.thingy.shahinportfolio.Entities.GSONSchemes.WorkExperienceScheme;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by shahin on 1/16/17.
 */

public interface PortfolioEndPoint {

    @GET("service.php")
    Call<PortfolioScheme> getPortfolioData(@Query("user_id") int user_id);

    @GET("operations.php")
    Call<ArrayList<EducationTrainingScheme>> getEducationData(@Query("user_id") int user_id, @Query("operation") int operation);

    @GET("operations.php")
    Call<ArrayList<WorkExperienceScheme>> getExperiencesData(@Query("user_id") int user_id, @Query("operation") int operation);

    @GET("operations.php")
    Call<ArrayList<ProjectScheme>> getProjectsData(@Query("user_id") int user_id, @Query("operation") int operation);

    @GET("operations.php")
    Call<ArrayList<SkillScheme>> getSkillsData(@Query("user_id") int user_id, @Query("operation") int operation);

    @GET("operations.php")
    Call<ArrayList<LanguageScheme>> getLanguagesData(@Query("user_id") int user_id, @Query("operation") int operation);

    @GET("operations.php")
    Call<ArrayList<HobbyInterestScheme>> getHobbiesData(@Query("user_id") int user_id, @Query("operation") int operation);


}
