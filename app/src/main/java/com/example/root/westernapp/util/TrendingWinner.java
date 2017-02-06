package com.example.root.westernapp.util;

/**
 * Created by root on 2/11/16.
 */

/**
 * Api type for Trending Products winner
 */
public class TrendingWinner {
    private int t_id;
    private int imageUrl;
    private String title;


    public TrendingWinner(int t_id, int imageUrl, String title) {
        this.t_id = t_id;
        this.imageUrl = imageUrl;
        this.title = title;

    }

    public int getT_id() {
        return t_id;
    }

    public void setT_id(int t_id) {
        this.t_id = t_id;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
