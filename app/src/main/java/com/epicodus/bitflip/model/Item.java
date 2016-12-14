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
    private String ownerName;
    private String ownerEmail;
    private String pushId;

    public Item(){};

    public Item(String category, String name, String description, String price, String imageUrl, String ownerEmail, String ownerName) {
        this.category = category;
        this.name = name;
        this.description = description;
        this.price = price;
        this.ownerName = ownerName;
        this.ownerEmail = ownerEmail;
        this.imageUrls.add(imageUrl);
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

    public String getOwnerName() { return ownerName; }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public String getPushId() {
        return pushId;
    }

    public List<String> getImageUrls() {
        return imageUrls;
    }

    public void addImageUrl(String imageUrl) {
        this.imageUrls.add(imageUrl);
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }

}
