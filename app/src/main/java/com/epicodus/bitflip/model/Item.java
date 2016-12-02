package com.epicodus.bitflip.model;

/**
 * Created by DroAlvarez on 12/1/16.
 */

public class Item {
    private String mCategory;
    private String mName;
    private String mPrice;
    private String mDescription;
    private String mImageUrl;

    public Item(String category, String name, String price, String imageUrl) {
        this.mCategory = category;
        this.mName = name;
        this.mPrice = price;
        this.mImageUrl = imageUrl;
    }

    public String getCategory() {
        return mCategory;
    }

    public String getName() {
        return mName;
    }

    public String getPrice() {
        return mPrice;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setDescription(String description) {
        this.mDescription = description;
    }
}
