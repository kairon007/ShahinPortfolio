package com.shahinjo.thingy.shahinportfolio;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by y.shahin on 1/30/2017.
 */

public class PortfolioApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);

    }
}
