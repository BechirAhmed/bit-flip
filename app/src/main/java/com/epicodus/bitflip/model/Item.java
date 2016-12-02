package com.epicodus.bitflip.model;

/**
 * Created by DroAlvarez on 12/1/16.
 */

public class Item {
    private String mName;
    private String mPrice;
    private String mDescription;
    private String mImageUrl;

    public Item(String name, String price, String description, String imageUrl) {
        this.mName = name;
        this.mPrice = price;
        this.mDescription = description;
        this.mImageUrl = imageUrl;
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
}
