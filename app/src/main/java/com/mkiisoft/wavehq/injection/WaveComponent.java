package com.mkiisoft.wavehq.injection;

import com.mkiisoft.wavehq.ui.home.HomeActivity;
import com.mkiisoft.wavehq.ui.home.module.HomeFragmentComponent;
import com.mkiisoft.wavehq.ui.home.module.HomeFragmentModule;
import com.mkiisoft.wavehq.ui.home.presenter.HomeFragmentPresenter;

import dagger.Component;

@Component(modules = {AppModule.class,
        HomeFragmentPresenter.class})
public interface WaveComponent {
    void inject(HomeActivity activity);

    HomeFragmentComponent newHomeFragmentComponent(HomeFragmentModule module);
}
