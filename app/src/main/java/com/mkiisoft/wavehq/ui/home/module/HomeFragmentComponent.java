package com.mkiisoft.wavehq.ui.home.module;

import com.mkiisoft.wavehq.ui.home.HomeFragment;

import javax.inject.Singleton;

import dagger.Subcomponent;

@Singleton
@Subcomponent(modules = {HomeFragmentModule.class})
public interface HomeFragmentComponent {
    void inject(HomeFragment view);
}
