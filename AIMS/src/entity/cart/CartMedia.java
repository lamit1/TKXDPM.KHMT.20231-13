package entity.cart;

import entity.media.Media;

public class CartMedia {
    
    private Media media;
    private int quantity;
    private int price;


    public CartMedia(Media media, Cart cart, int quantity, int price) {
        this.media = media;
        this.quantity = quantity;
        this.price = price;
    }

    /**
     * All function here are all communicational cohesion
     * because all are used for purpose get cart media information
     */

    public Media getMedia() {
        return this.media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


}

    
