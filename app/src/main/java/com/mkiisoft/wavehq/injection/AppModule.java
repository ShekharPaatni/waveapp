package com.mkiisoft.wavehq.injection;

import com.mkiisoft.wavehq.application.WaveApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    WaveApplication application;

    public AppModule(WaveApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public WaveApplication providesApplication() {
        return application;
    }
}
