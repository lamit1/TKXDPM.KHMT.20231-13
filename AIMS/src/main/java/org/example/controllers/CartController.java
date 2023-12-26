package org.example.controllers;
import org.example.exceptions.NoMediaInCartException;
import org.example.models.Cart;
import org.example.models.Media;
import org.example.exceptions.InvalidQuantityException;
import org.example.exceptions.NotEnoughQuantityException;

import java.util.HashMap;
import java.util.List;

public class CartController {
    private Cart cart = Cart.getCart();

    public double getCartAmounts()  {
        try {
            return cart.getCartAmounts();
        } catch (NoMediaInCartException e) {
            return 0;
        }
    }

    public void decreaseMedia(Media media) {
        cart.decreaseMedia(media);
    }

    public void increaseMedia(Media media) throws NotEnoughQuantityException {
        cart.increaseMedia(media);
    }

    public List<HashMap<Media, Integer>> getMediaItems() {
        return cart.getMediaItems();
    }
    public void addMedia(Media media, int quantity) throws NotEnoughQuantityException, InvalidQuantityException {
        cart.addMedia(media, quantity);
    }
    public void removeMedia(Media media) {
        cart.removeMedia(media);
    }
}
