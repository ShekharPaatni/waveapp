package com.mkiisoft.wavehq.ui.presenter;

import android.app.Activity;

import androidx.annotation.CallSuper;

public abstract class BaseFragmentPresenter<View extends FragmentView> implements FragmentPresenter {

    protected View fragmentView;
    protected boolean viewIsPaused;

    public BaseFragmentPresenter(View fragmentView) {
        this.fragmentView = fragmentView;
    }

    @CallSuper
    protected void onViewBecameActive() {

    }

    @CallSuper
    @Override
    public void onStart() {

    }

    @CallSuper
    @Override
    public void onResume() {
        viewIsPaused = false;
        onViewBecameActive();
    }

    @CallSuper
    protected void onViewPaused() {
        // no-op
    }

    @CallSuper
    @Override
    public void onPause() {
        viewIsPaused = true;
        onViewPaused();
    }

    @CallSuper
    @Override
    public void onDestroy() {
        fragmentView = null;
    }

    @CallSuper
    @Override
    public void onStop() {

    }

    @Override
    public Activity getActivity() {
        return fragmentView == null ? null : fragmentView.getActivity();
    }
}
