package com.example.root.westernapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.root.westernapp.R;

/**
 * Created by root on 3/11/16.
 */
public class NextTabFragment extends Fragment {

    public NextTabFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.next_tab_layout,container,false);
    }
}
