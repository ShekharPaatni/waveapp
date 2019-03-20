package com.mkiisoft.wavehq.ui.home;

import android.os.Bundle;

import com.mkiisoft.wavehq.R;
import com.mkiisoft.wavehq.application.WaveApplication;
import com.mkiisoft.wavehq.ui.base.BaseActivity;

import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class HomeActivity extends BaseActivity {

    private NavController navController;
    private AppBarConfiguration appBarConfig;

    @Override
    public int getLayout() {
        return R.layout.activity_home;
    }

    @Override
    public void toCreate(Bundle savedInstanceStat) {
        ((WaveApplication) getApplication()).get().inject(this);
    }

    @Override
    public void init() {
        NavHostFragment navHost = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.nav_host_fragment);

        if (navHost != null) navController = navHost.getNavController();

        appBarConfig = new AppBarConfiguration.Builder().build();
        NavigationUI.setupActionBarWithNavController(this, navController);

        getSupportActionBar().hide();
    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController, appBarConfig);
    }
}
