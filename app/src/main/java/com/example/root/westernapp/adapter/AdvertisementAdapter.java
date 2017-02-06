package com.example.root.westernapp.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.root.westernapp.R;

import java.util.List;

/**
 * Created by root on 2/11/16.
 */

//Advertisement Adapter for View Pager
public class AdvertisementAdapter extends PagerAdapter {

    Context mContext;
    LayoutInflater mLayoutInflater;
    List<Integer> mResources;

    public AdvertisementAdapter(Context context, List<Integer> resources) {
        mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mResources = resources;
    }

    @Override
    public int getCount() {
        return mResources.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.advertisement_item_layout, container, false);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.iv_ad);
        imageView.setImageResource(mResources.get(position));

        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}