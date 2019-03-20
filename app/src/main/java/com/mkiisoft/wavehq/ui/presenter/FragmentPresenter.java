package com.mkiisoft.wavehq.ui.presenter;

import android.app.Activity;

public interface FragmentPresenter {

    void onStart();

    void onResume();

    void onPause();

    void onDestroy();

    void onStop();

    Activity getActivity();
}
