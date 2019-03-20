package com.mkiisoft.wavehq.application;

import android.content.IntentFilter;
import android.net.ConnectivityManager;

import com.mkiisoft.wavehq.injection.DaggerWaveComponent;
import com.mkiisoft.wavehq.injection.WaveComponent;
import com.mkiisoft.wavehq.util.connectivity.ConnectivityChangeReceiver;

import io.realm.Realm;

public class WaveApplication extends BaseApplication {

    private static WaveApplication instance;
    private WaveComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        this.onPreInitialize();
        Realm.init(this);
        registerReceiver(new ConnectivityChangeReceiver(),
                new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
    }

    @Override
    public void initComponent() {
        component = DaggerWaveComponent.create();
    }

    public static WaveApplication getInstance() {
        return instance;
    }

    protected void onPreInitialize() {
        instance = this;
    }

    public WaveComponent get() {
        return component;
    }
}
