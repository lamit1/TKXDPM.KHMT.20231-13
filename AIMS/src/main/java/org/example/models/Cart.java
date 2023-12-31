package org.example.models;

import org.example.exceptions.InvalidQuantityException;
import org.example.exceptions.NoMediaInCartException;
import org.example.exceptions.NotEnoughQuantityException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Cart {
    private List<HashMap<Media,Integer>> mediaList = new ArrayList<HashMap<Media,Integer>>();
    private Cart() {}
    private static Cart cart;
    public static Cart  getCart() {
        if (cart == null) {
            cart = new Cart();
        }
        return cart;
    }

    public void addMedia(Media media, int quantity) throws NotEnoughQuantityException, InvalidQuantityException {
        if (quantity<0) {
            throw new InvalidQuantityException("Invalid quantity!");
        }
        if (quantity > media.getAvailable()) {
            throw new NotEnoughQuantityException("There are only " + media.getAvailable() + " available. You ask " + quantity);
        }
        for (HashMap<Media, Integer> mediaMap : mediaList) {
            if (mediaMap.containsKey(media)) {
                Integer currentQuantity = mediaMap.get(media);
                mediaMap.put(media, currentQuantity + quantity);
                return;
            }
        }
        HashMap<Media, Integer> newMediaMap = new HashMap<>();
        newMediaMap.put(media, quantity);
        mediaList.add(newMediaMap);
    }

    public void decreaseMedia(Media media){
        int quantity = 1;
        for (HashMap<Media, Integer> mediaMap : mediaList) {
            if (mediaMap.containsKey(media)) {
                Integer currentQuantity = mediaMap.get(media);
                mediaMap.put(media, Math.max(0, currentQuantity - quantity)); // Ensure quantity doesn't go below 0
                return;
            }
        }
    }
    public void increaseMedia(Media media) throws NotEnoughQuantityException {
        int quantity = 1; // Increase by 1
        if (quantity > media.getAvailable()) {
            throw new NotEnoughQuantityException("There are only " + media.getAvailable() + " available. You asked for " + quantity);
        }
        for (HashMap<Media, Integer> mediaMap : mediaList) {
            if (mediaMap.containsKey(media)) {
                Integer currentQuantity = mediaMap.get(media);
                mediaMap.put(media, currentQuantity + quantity);
                return;
            }
        }
    }

    public void removeMedia(Media media) {
        for (HashMap<Media, Integer> mediaMap : mediaList) {
            if (mediaMap.containsKey(media)) {
                mediaList.remove(mediaMap);
                System.out.println("Removed media in Cart");
                return;
            }
        }
    }

    public double getCartAmounts() throws NoMediaInCartException {
        if (isCartEmpty())
                throw new NoMediaInCartException("No media in cart");
        double cartAmounts = 0;
        for (HashMap<Media, Integer> mediaMap: mediaList) {
            for (Media media : mediaMap.keySet()) {
                int quantity = mediaMap.get(media);
                double mediaPrice = media.getPrice();
                cartAmounts += quantity * mediaPrice;
            }
        }
        return cartAmounts;
    }

    public void clearCart() {
        mediaList.clear();
    }

    public double getWeights() {
        double totalWeights = 0;
        for (HashMap<Media, Integer> mediaMap: mediaList) {
            for (Media media : mediaMap.keySet()) {
                int quantity = mediaMap.get(media);
                double mediaWeight = media.getWeight();
                totalWeights += quantity * mediaWeight;
            }
        }
        return totalWeights;
    }

    public double getRushAmounts() {
        List<HashMap<Media, Integer>> rushMediaList =  mediaList.stream()
                .filter(mediaMap -> mediaMap.keySet().stream().anyMatch(Media::isRushDelivery))
                .toList();
        double rushAmounts = 0;
        for (HashMap<Media, Integer> mediaMap: rushMediaList) {
            for (Media media : mediaMap.keySet()) {
                int quantity = mediaMap.get(media);
                rushAmounts += quantity * 10000;
            }
        }
        return rushAmounts;
    }

    public List<HashMap<Media, Integer>> getMediaItems() {
        List<HashMap<Media, Integer>> currentMediaList = new ArrayList<>(mediaList);
        return currentMediaList;
    }

    public boolean isRushDeliverySupport() {
        for (HashMap<Media, Integer> mediaMap : mediaList) {
            for (Media media : mediaMap.keySet()) {
                if (media.isRushDelivery()) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isCartEmpty() {
        return mediaList.isEmpty();
    }
}
