package com.mkiisoft.wavehq.ui.home.adapter;

import android.view.View;
import android.widget.TextView;

import com.mkiisoft.wavehq.R;
import com.mkiisoft.wavehq.data.model.Product;
import com.xwray.groupie.Item;
import com.xwray.groupie.ViewHolder;

import androidx.annotation.NonNull;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductItem extends Item {

    @BindView(R.id.product_letter)
    protected TextView letter;
    @BindView(R.id.product_name)
    protected TextView name;
    @BindView(R.id.product_description)
    protected TextView description;
    @BindView(R.id.product_price)
    protected TextView price;
    @BindView(R.id.product_sell)
    protected TextView forSell;

    private Product product;

    @Override
    public int getLayout() {
        return R.layout.item_product;
    }

    public ProductItem(Product product) {
        this.product = product;
    }

    @Override
    public void bind(@NonNull ViewHolder viewHolder, int position) {
        ButterKnife.bind(this, viewHolder.itemView);

        letter.setText(product.getName().substring(0, 1).toUpperCase());
        name.setText(product.getName());
        description.setText(product.getDescription());
        price.setText(String.format(viewHolder.itemView.getContext().getString(R.string.dollar),
                product.getPrice()));

        forSell.setVisibility(product.getSold() ? View.VISIBLE : View.GONE);

    }
}
