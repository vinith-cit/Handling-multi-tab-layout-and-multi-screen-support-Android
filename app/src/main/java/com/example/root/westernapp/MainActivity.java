package com.example.root.westernapp;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.root.westernapp.adapter.MainViewPagerAdapter;
import com.example.root.westernapp.fragments.FirstTabFragment;
import com.example.root.westernapp.fragments.NextTabFragment;

public class MainActivity extends AppCompatActivity {

    //Activity Tool Bar
    private Toolbar mToolBar;

    //Parent Tab Layout
    private TabLayout mTabLayout;

    //Activity main view pager
    private ViewPager mMainViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolBar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolBar);

        mMainViewPager = (ViewPager) findViewById(R.id.viewpager);
        mTabLayout = (TabLayout) findViewById(R.id.tabs);

        //Set Adapter for View Pager
        setupViewPager(mMainViewPager);
        mTabLayout.setupWithViewPager(mMainViewPager);

        //Setting Icons for Tabs
        setupTabIcons();
        //Setting Current Tab
        setListner();


    }

    //Setting Icons for Tabs
    private void setupTabIcons() {
        mTabLayout.getTabAt(0).setIcon(R.drawable.dollar);
        mTabLayout.getTabAt(1).setIcon(R.drawable.ic_cup);
        mTabLayout.getTabAt(2).setIcon(R.drawable.ic_camera);
        mTabLayout.getTabAt(3).setIcon(R.drawable.ic_menu);

    }

    //Set Adapter for View Pager

    private void setupViewPager(ViewPager viewPager) {
        MainViewPagerAdapter adapter = new MainViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FirstTabFragment(), "Doller");
        adapter.addFragment(new NextTabFragment(), "Cup");
        adapter.addFragment(new NextTabFragment(), "Camera");
        adapter.addFragment(new NextTabFragment(), "Menu");

        viewPager.setAdapter(adapter);


    }

    //Setting Current Tab
    private void setListner() {
        mMainViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mMainViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }


}
