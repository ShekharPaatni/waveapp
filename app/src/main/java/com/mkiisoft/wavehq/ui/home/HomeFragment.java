package com.mkiisoft.wavehq.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.mkiisoft.wavehq.R;
import com.mkiisoft.wavehq.application.WaveApplication;
import com.mkiisoft.wavehq.data.model.Product;
import com.mkiisoft.wavehq.ui.home.adapter.ProductItem;
import com.mkiisoft.wavehq.ui.home.module.HomeFragmentComponent;
import com.mkiisoft.wavehq.ui.home.module.HomeFragmentModule;
import com.mkiisoft.wavehq.ui.home.presenter.HomeFragmentPresenter;
import com.mkiisoft.wavehq.ui.home.presenter.HomeFragmentView;
import com.mkiisoft.wavehq.ui.presenter.MvpFragment;
import com.xwray.groupie.GroupAdapter;
import com.xwray.groupie.ViewHolder;

import java.util.List;
import java.util.Objects;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeFragment extends MvpFragment<HomeFragmentPresenter> implements HomeFragmentView {

    @BindView(R.id.home_recycler)
    protected RecyclerView recyclerView;
    @BindView(R.id.home_toggle)
    protected ImageView toggle;

    @BindView(R.id.home_network)
    protected LinearLayout network;
    @BindView(R.id.home_network_icon)
    protected ImageView networkIcon;
    @BindView(R.id.home_network_text)
    protected TextView networkText;

    @BindView(R.id.home_loading)
    protected ProgressBar loading;

    private GroupAdapter<ViewHolder> adapter;

    private boolean layoutToggle;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HomeFragmentComponent component = ((WaveApplication)
                Objects.requireNonNull(getActivity()).getApplication()).get()
                .newHomeFragmentComponent(new HomeFragmentModule(this));
        component.inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        setupViews();
        return view;
    }

    private void setupViews() {
        recyclerView.setLayoutManager(getLayoutManager(getActivity(), LinearLayoutManager.class));
        adapter = new GroupAdapter<>();
        recyclerView.setAdapter(adapter);
        presenter.init();
    }

    @Override
    public void setHomeListContent(List<Product> products) {
        loading.setVisibility(View.GONE);
        adapter.clear();
        for (Product product : products) {
            adapter.add(new ProductItem(product));
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public void loading() {
        loading.setVisibility(View.VISIBLE);
        network.setVisibility(View.GONE);
    }

    @Override
    public void handleError(Exception exception) {
        loading.setVisibility(View.GONE);
        showNetworkAlert(true);
    }

    @Override
    public void noNetwork() {
        showNetworkAlert(false);
    }

    private void showNetworkAlert(boolean isError) {
        network.setVisibility(View.VISIBLE);
        if (isError) {
            networkIcon.setImageDrawable(ContextCompat.getDrawable(Objects.requireNonNull(getActivity()),
                    R.drawable.data_error));
            networkText.setText(getString(R.string.data_error));
        } else {
            networkIcon.setImageDrawable(ContextCompat.getDrawable(Objects.requireNonNull(getActivity()),
                    R.drawable.data_no_network));
            networkText.setText(getString(R.string.no_connection));
        }
    }

    @OnClick(R.id.home_toggle)
    void toggleView() {
        toggle.setImageDrawable(!layoutToggle
                ? ContextCompat.getDrawable(Objects.requireNonNull(getActivity()), R.drawable.list_view)
                : ContextCompat.getDrawable(Objects.requireNonNull(getActivity()), R.drawable.grid_view));
        layoutToggle = !layoutToggle;
        recyclerView.setLayoutManager(getLayoutManager(getActivity(), LinearLayoutManager.class));
    }

    private <T extends LinearLayoutManager> T getLayoutManager(Context context, Class<T> type) {
        return !layoutToggle
                ? type.cast(new LinearLayoutManager(context, RecyclerView.VERTICAL, false))
                : type.cast(new GridLayoutManager(context, 2));
    }
}
