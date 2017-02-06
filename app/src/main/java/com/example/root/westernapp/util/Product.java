package com.example.root.westernapp.util;

/**
 * Created by root on 2/11/16.
 */


/**
 * product Api type for all products showing Child Tab Layout
 */
public class Product {

    private int p_id;
    private int imageUrl;
    private String title;
    private int progress;
    private boolean addToCard;


    public Product(int p_id,int imageUrl, String title,int progress,boolean addToCard) {
        this.p_id = p_id;
        this.imageUrl = imageUrl;
        this.title = title;
        this.progress = progress;
        this.addToCard = addToCard;

    }

    public boolean isAddToCard() {
        return addToCard;
    }

    public void setAddToCard(boolean addToCard) {
        this.addToCard = addToCard;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public int getP_id() {
        return p_id;
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
