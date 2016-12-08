package com.epicodus.bitflip.model;

import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DroAlvarez on 12/1/16.
 */

@Parcel
public class Item {
    private String category;
    private String name;
    private String price;
    private String description;
    private List<String> imageUrls = new ArrayList<String>();

    public Item(){};

    public Item(String category, String name, String description, String price) {
        this.category = category;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getImageUrl() {
        return imageUrls;
    }

    public void addImageUrl(String imageUrl) {
        this.imageUrls.add(imageUrl);
    }

}
