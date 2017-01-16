package com.shahinjo.thingy.shahinportfolio.Managers;

import com.shahinjo.thingy.shahinportfolio.Entities.GSONSchemes.PortfolioScheme;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by shahin on 1/16/17.
 */

public interface PortfolioEndPoint {

    @GET("service.php")
    Call<PortfolioScheme> getPortfolioData(@Query("user_id") int user_id);

}
