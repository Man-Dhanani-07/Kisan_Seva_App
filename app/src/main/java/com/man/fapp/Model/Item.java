package com.man.fapp.Model;

public class Item {
       private String title;
       private String quality;
       private String quantity;
       private String imageUrl;
       private String price;
       private String description;

    public Item() {
    }

    public Item(String title, String quality, String quantity, String imageUrl, String price, String description) {
        this.title = title;
        this.quality = quality;
        this.quantity = quantity;
        this.imageUrl = imageUrl;
        this.price = price;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
