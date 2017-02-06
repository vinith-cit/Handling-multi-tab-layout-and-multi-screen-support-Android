package com.example.root.westernapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.root.westernapp.R;
import com.example.root.westernapp.util.TrendingWinner;

import java.util.List;

/**
 * Created by root on 2/11/16.
 */
//Trending Adapter for Recyclerview below child Tab Layout
public class TrendingAdapter extends RecyclerView.Adapter<TrendingAdapter.TrendingViewHolder> {

    Context context;
    List<TrendingWinner> trendingWinnerList;

    public TrendingAdapter(Context context, List<TrendingWinner> trendingWinnerList) {
        this.context = context;
        this.trendingWinnerList = trendingWinnerList;
    }

    @Override
    public TrendingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.trending_item_layout, parent, false);
        return new TrendingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TrendingViewHolder holder, int position) {
        TrendingWinner trendingWinner = trendingWinnerList.get(position);
        holder.ivTrending.setImageResource(trendingWinner.getImageUrl());
        holder.tvTitle.setText(trendingWinner.getTitle());

    }

    @Override
    public int getItemCount() {
        return trendingWinnerList.size();
    }


    //View Holder for Trending Adapter
    public class TrendingViewHolder extends RecyclerView.ViewHolder {

        public TextView tvTitle;
        public ImageView ivTrending;

        public TrendingViewHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_trending);
            ivTrending = (ImageView) itemView.findViewById(R.id.iv_trending);
        }
    }

}
