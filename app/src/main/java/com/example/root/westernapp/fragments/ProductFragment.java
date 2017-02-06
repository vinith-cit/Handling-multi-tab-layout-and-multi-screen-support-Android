package com.example.root.westernapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.root.westernapp.R;
import com.example.root.westernapp.adapter.ProductAdapter;
import com.example.root.westernapp.util.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 2/11/16.
 */


//Product Fragment Child Tab Fragment
public class ProductFragment extends Fragment {

    //Product Recycler view
    RecyclerView productRecyclerView;

    //Product Listt
    List<Product> mProductList;

    public ProductFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.product_layout, container, false);
        productRecyclerView = (RecyclerView)view.findViewById(R.id.rvProduct);

        //Setting Adapter for Product RecyclerView
        setUpRecyclerView();

        return view;
    }


    //Setting Adapter for Product RecyclerView
    private void setUpRecyclerView() {

        productRecyclerView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        productRecyclerView.setLayoutManager(gridLayoutManager);
        ProductAdapter adapter = new ProductAdapter(getActivity(), getProductList());
        productRecyclerView.setAdapter(adapter);
    }

    //Getting Product List
    private List<Product> getProductList() {
        mProductList = new ArrayList<>();
        mProductList.add(new Product(1, R.drawable.ic_mac_book, "13 - inch mac book ratina display", 72, false));
        mProductList.add(new Product(2, R.drawable.ic_pendrive, "San disk 16 GB Pen Drive", 60, false));

        mProductList.add(new Product(1, R.drawable.ic_mac_book, "13 - inch mac book ratina display", 72, false));
        mProductList.add(new Product(2, R.drawable.ic_pendrive, "San disk 16 GB Pen Drive", 60, false));

        mProductList.add(new Product(1, R.drawable.ic_mac_book, "13 - inch mac book ratina display", 72, false));
        mProductList.add(new Product(2, R.drawable.ic_pendrive, "San disk 16 GB Pen Drive", 60, false));

        mProductList.add(new Product(1, R.drawable.ic_mac_book, "13 - inch mac book ratina display", 72, false));
        mProductList.add(new Product(2, R.drawable.ic_pendrive, "San disk 16 GB Pen Drive", 60, false));

        mProductList.add(new Product(1, R.drawable.ic_mac_book, "13 - inch mac book ratina display", 72, false));
        mProductList.add(new Product(2, R.drawable.ic_pendrive, "San disk 16 GB Pen Drive", 60, false));

        return mProductList;
    }
}

