package com.main.tracker;

import android.app.Application;

import com.main.tracker.model.CycleRepository;

public class MensApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CycleRepository.initialize(getApplicationContext());
    }
}
