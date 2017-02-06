package com.example.root.westernapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.root.westernapp.R;
import com.example.root.westernapp.util.Product;

import java.util.List;

/**
 * Created by root on 2/11/16.
 */

//Product Adapter for Recyclerview below child Tab Layout
public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    List<Product> productList;
    Context context;

    public ProductAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item_layout, parent, false);
        return new ProductViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.tvTitle.setText(product.getTitle());
        holder.ivProduct.setImageResource(product.getImageUrl());
        holder.progressBar.setProgress(product.getProgress());
        holder.tvProgress.setText(" " + product.getProgress() + " % in Progress");

    }


    @Override
    public int getItemCount() {
        return productList.size();
    }


    //View Holder for Product Adapter
    public class ProductViewHolder extends RecyclerView.ViewHolder {
        public TextView tvTitle, tvProgress;
        public ImageView ivProduct;
        public ProgressBar progressBar;

        public ProductViewHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_trending);
            ivProduct = (ImageView) itemView.findViewById(R.id.iv_trending);
            tvProgress = (TextView) itemView.findViewById(R.id.tv_progress);
            progressBar = (ProgressBar) itemView.findViewById(R.id.progressbar);

        }
    }
}