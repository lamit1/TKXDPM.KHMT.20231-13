package entity.cart;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.exception.MediaNotAvailableException;
import entity.media.Media;
import entity.media.QuantityMedia;

/**
 * Thực hiện đúng Single Responsibility:
 * Thực hiện các chức năng liên quan đến Cart như add, remove, calculate, ...
 */
public class Cart {
    private final List<QuantityMedia> mediaList;
    private static Cart cartInstance;
    public static Cart getCart(){
        if(cartInstance == null) cartInstance = new Cart();
        return cartInstance;
    }
    private Cart(){
        mediaList = new ArrayList<>();
    }
    /**
     * addCartMedia, removeCartMedia, getListMedia, emptyCart
     * getTotalMedia, calSubtotal, checkMediaInCart
     * are communicational cohesion because work on
     * the same data Cart
     */
    public void addCartMedia(QuantityMedia media){
        QuantityMedia existingMedia = checkMediaInCart(media.getMedia());
        if (existingMedia != null) {
            existingMedia.setQuantity(existingMedia.getQuantity() + media.getQuantity());
        } else {
            mediaList.add(media);
        }
    }
    public void removeCartMedia(QuantityMedia media){
        if(media != null){
            mediaList.remove(media);
        }
    }
    /*
        Content coupling
     */
    public List<QuantityMedia> getListMedia(){
        return mediaList;
    }
    public void emptyCart(){
        mediaList.clear();
    }
    public int getTotalMedia(){
        int total = 0;
        for (QuantityMedia media : mediaList) {
            total += media.getQuantity();
        }
        return total;
    }
    public int calSubtotal(){
        int total = 0;
        for (QuantityMedia media : mediaList) {
            total += media.getPrice() * media.getQuantity();
        }
        return total;
    }
    /**
     * Coincedential cohesion because
     * this function have no relation to cart
     */
    public void checkAvailabilityOfProduct() throws SQLException{
        boolean allAvai = true;
        for (QuantityMedia quantityMedia : mediaList) {
            int requiredQuantity = quantityMedia.getQuantity();
            int availQuantity = quantityMedia.getMedia().getQuantity();
            if (requiredQuantity > availQuantity) allAvai = false;
        }
        if (!allAvai) throw new MediaNotAvailableException("Some media not available");
    }
    public QuantityMedia checkMediaInCart(Media media){
        for (QuantityMedia quantityMedia : mediaList) {
            if (quantityMedia.getMedia().getId() == media.getId()) return quantityMedia;
        }
        return null;
    }

}
