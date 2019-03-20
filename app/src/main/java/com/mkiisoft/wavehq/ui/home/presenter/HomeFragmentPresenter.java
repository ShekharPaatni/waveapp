package com.mkiisoft.wavehq.ui.home.presenter;

import com.mkiisoft.wavehq.data.client.WaveClient;
import com.mkiisoft.wavehq.ui.presenter.BaseFragmentPresenter;
import com.mkiisoft.wavehq.util.Constants;
import com.mkiisoft.wavehq.util.connectivity.ConnectivityManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import dagger.Module;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

@Module
public class HomeFragmentPresenter extends BaseFragmentPresenter<HomeFragmentView> implements ConnectivityManager.ConnectionChangedListener {

    private Disposable subscriber;
    private ConnectivityManager connectivityManager;

    @Inject
    public HomeFragmentPresenter(HomeFragmentView fragmentView) {
        super(fragmentView);
    }

    public void init() {
        connectivityManager = ConnectivityManager.get(getActivity());
        getProducts();
    }

    @Override
    public void onResume() {
        super.onResume();
        connectivityManager.addConnectivityListener(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        subscriber.dispose();
        connectivityManager.removeConnectivityListener(this);
    }

    private void getProducts() {
        fragmentView.loading();

        Map<String, String> headers = new HashMap<>();
        headers.put(Constants.AUTH, Constants.TOKEN);

        subscriber = new WaveClient().initClient()
                .getProducts(headers, Constants.BUSINESS_ID)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(product -> fragmentView.setHomeListContent(product),
                        error -> fragmentView.handleError((Exception) error));
    }

    @Override
    public void onConnected() {
        getProducts();
    }

    @Override
    public void onDisconnected() {
        fragmentView.setHomeListContent(new ArrayList<>());
        fragmentView.noNetwork();
    }
}