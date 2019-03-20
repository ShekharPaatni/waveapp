package com.mkiisoft.wavehq.ui.home.module;

import android.app.Activity;

import com.mkiisoft.wavehq.ui.home.presenter.HomeFragmentView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class HomeFragmentModule {

    private final HomeFragmentView view;

    public HomeFragmentModule(HomeFragmentView view) {
        this.view = view;
    }

    @Singleton
    @Provides
    public HomeFragmentView provideFragmentView() {
        return view;
    }

    @Singleton
    @Provides
    public Activity provideActivity() {
        return view.getActivity();
    }
}