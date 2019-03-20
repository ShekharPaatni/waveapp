package com.mkiisoft.wavehq.application;

import android.app.Application;

public abstract class BaseApplication extends Application {

    private static BaseApplication instance;

    public abstract void initComponent();

    public static BaseApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        this.onInitialize();
    }

    protected void onInitialize() {
        initComponent();
    }
}