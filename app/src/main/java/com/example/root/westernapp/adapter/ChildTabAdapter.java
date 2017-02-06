package com.example.root.westernapp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 3/11/16.
 */

//ChildTabAdapter for Tab Layout

public class ChildTabAdapter extends FragmentPagerAdapter {

    List<Fragment> fragList = new ArrayList<>();
    List<String> titleList = new ArrayList<>();

    public ChildTabAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addFrag(Fragment f, String title) {
        fragList.add(f);
        titleList.add(title);
    }

    @Override
    public Fragment getItem(int position) {
        return fragList.get(position);
    }

    @Override
    public int getCount() {
        return fragList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }
}
