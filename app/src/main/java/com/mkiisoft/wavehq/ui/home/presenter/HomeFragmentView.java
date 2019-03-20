package com.mkiisoft.wavehq.ui.home.presenter;

import com.mkiisoft.wavehq.data.model.Product;
import com.mkiisoft.wavehq.ui.presenter.FragmentView;

import java.util.List;

public interface HomeFragmentView extends FragmentView {
    void setHomeListContent(List<Product> products);
    void handleError(Exception exception);
    void noNetwork();
    void loading();
}