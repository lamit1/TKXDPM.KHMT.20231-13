package org.example.models;

public class Media {
    private int id;
    private String name;
    private double price;
    private boolean rushDelivery;
    private double weight;
    private int availabel;
    private String imageUrl;
    private String category;

    @Override
    public int hashCode() {
        return name.hashCode();
    }



    public boolean isRushDelivery() {
        return rushDelivery;
    }

    public double getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }

    public int getAvailable() {
        return availabel;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        Media media = (Media) obj;
        return this.id == media.id;
    }

    public Media(String name, double price, boolean rushDelivery, double weight, int availabel, String imageUrl, String category) {
        this.name = name;
        this.price = price;
        this.rushDelivery = rushDelivery;
        this.weight = weight;
        this.availabel = availabel;
        this.imageUrl = imageUrl;
        this.category = category;
    }

    public Media(int id, String name, double price, boolean rushDelivery, double weight, int availabel, String imageUrl, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.rushDelivery = rushDelivery;
        this.weight = weight;
        this.availabel = availabel;
        this.imageUrl = imageUrl;
        this.category = category;
    }

    public int getId() {
        return id;
    }
}
