package com.example.root.westernapp.fragments;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.root.westernapp.NonScrollableVP;
import com.example.root.westernapp.R;
import com.example.root.westernapp.adapter.AdvertisementAdapter;
import com.example.root.westernapp.adapter.ChildTabAdapter;
import com.example.root.westernapp.adapter.TrendingAdapter;
import com.example.root.westernapp.util.TrendingWinner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 1/11/16.
 */


/**
 * First Tab Fragment for doller tabb
 */
public class FirstTabFragment extends Fragment implements ViewPager.OnPageChangeListener {

    //Advertisement view Pager
    ViewPager mAdvertisementViewPager;

    //Trending RecyclerView
    RecyclerView mTrendingRecyclerView;

    //Trending data list
    List<TrendingWinner> mTrendingWinnerList;

    //Parent Tab_layout
    TabLayout mTabLayout;

    //add Circle Page Indicator dynammic in this layout
    LinearLayout mPager_indicator;

    //Non scrollable View Pager for Child Tab
    NonScrollableVP mNonScrollableVp;


    //Dots count
    private int mDotsCount;

    //imageview for mDotsIv
    private ImageView[] mDotsIv;

    //view Pager Adapter
    AdvertisementAdapter mAdvertisementAdapter;

    public FirstTabFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.first_tab_layout, container, false);
        mAdvertisementViewPager = (ViewPager) view.findViewById(R.id.pager);
        mTrendingRecyclerView = (RecyclerView) view.findViewById(R.id.trending_recyclerView);
        mTabLayout = (TabLayout) view.findViewById(R.id.tabNonScrollable);
        mNonScrollableVp = (NonScrollableVP) view.findViewById(R.id.vpNews);
        mPager_indicator = (LinearLayout) view.findViewById(R.id.viewPagerCountDots);

        //Set Adapter for View Pager
        setmAdvertisementViewPager();

        //Set Adapter for RecyclerView
        setmTrendingRecyclerView();

        //Dynamic circle page indicator creation
        setUiPageViewController();

        //Listner for view Pager Scrolling
        mAdvertisementViewPager.setOnPageChangeListener(this);

        //Set Adapter for Child Tab Layout
        setUpPager();


        return view;
    }


    //Dynamic circle page indicator creation
    private void setUiPageViewController() {

        mDotsCount = mAdvertisementAdapter.getCount();
        mDotsIv = new ImageView[mDotsCount];

        for (int i = 0; i < mDotsCount; i++) {
            mDotsIv[i] = new ImageView(getActivity());
            mDotsIv[i].setImageDrawable(getResources().getDrawable(R.drawable.nonselecteditem_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

            params.setMargins(4, 0, 4, 0);

            mPager_indicator.addView(mDotsIv[i], params);
        }

        mDotsIv[0].setImageDrawable(getResources().getDrawable(R.drawable.selecteditem_dot));
    }

    //Set Adapter for RecyclerView
    public void setmTrendingRecyclerView() {
        LinearLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        mTrendingRecyclerView.setLayoutManager(gridLayoutManager);
        TrendingAdapter trendingAdapter = new TrendingAdapter(getActivity(), getTrendingList());

        mTrendingRecyclerView.setAdapter(trendingAdapter);

    }

    public List<TrendingWinner> getTrendingList() {
        mTrendingWinnerList = new ArrayList<>();
        mTrendingWinnerList.add(new TrendingWinner(1, R.drawable.ic_mac_book, "13-inch Apple MacBook Pro with Retina Display"));
        mTrendingWinnerList.add(new TrendingWinner(2, R.drawable.ic_pendrive, "Sandisk 16 GB Pen Drive"));
        mTrendingWinnerList.add(new TrendingWinner(3, R.drawable.ic_pendrive, "Sandisk 32 GB Pen Drive"));

        return mTrendingWinnerList;

    }

    //Set Adapter for View Pager
    public void setmAdvertisementViewPager() {
        List<Integer> imagelist = new ArrayList<>();
        imagelist.add(R.drawable.ad1);
        imagelist.add(R.drawable.ad2);
        mAdvertisementAdapter = new AdvertisementAdapter(getActivity(), imagelist);
        mAdvertisementViewPager.setAdapter(mAdvertisementAdapter);


    }


    //Set Adapter for Child Tab Layout
    private void setUpPager() {
        ChildTabAdapter adp = new ChildTabAdapter(getChildFragmentManager());
        ProductFragment n1 = new ProductFragment();
        ProductFragment n2 = new ProductFragment();
        ProductFragment n3 = new ProductFragment();
        ProductFragment n4 = new ProductFragment();

        adp.addFrag(n1, "Trending");
        adp.addFrag(n2, "Latest");
        adp.addFrag(n3, "UpComing");
        adp.addFrag(n4, "Price");

        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
        mNonScrollableVp.setAdapter(adp);
        mNonScrollableVp.setOffscreenPageLimit(12);
        mTabLayout.setupWithViewPager(mNonScrollableVp);
    }

    //Set Adapter for Child Tab Layout

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


    }

    @Override
    public void onPageSelected(int position) {
        for (int i = 0; i < mDotsCount; i++) {
            mDotsIv[i].setImageDrawable(getResources().getDrawable(R.drawable.nonselecteditem_dot));
        }

        mDotsIv[position].setImageDrawable(getResources().getDrawable(R.drawable.selecteditem_dot));


    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}





