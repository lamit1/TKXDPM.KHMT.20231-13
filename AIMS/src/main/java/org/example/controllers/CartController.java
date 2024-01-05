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


    //Tính tổng số tiền
    public double getCartAmounts()  {
        try {
            return cart.getCartAmounts();
        } catch (NoMediaInCartException e) {
            return 0;
        }
    }

    //Giảm số lượng sản phẩm của giỏ hàng
    public void decreaseMedia(Media media) {
        cart.decreaseMedia(media);
    }


    //Tăng số lượng sản phẩm trong giỏ hàng
    public void increaseMedia(Media media) throws NotEnoughQuantityException {
        cart.increaseMedia(media);
    }

    //Lấy danh sách sản phẩm của giỏ hàng
    public List<HashMap<Media, Integer>> getMediaItems() {
        return cart.getMediaItems();
    }

    //Lấy danh sách sản phẩm muốn mua
    public List<HashMap<Media, Integer>> getMediaBuyItems() {
        return cart.getMediaBuyItems();
    }


    //Thêm sản phẩm vào giỏ hàng
    public void addMedia(Media media, int quantity) throws NotEnoughQuantityException, InvalidQuantityException {
        cart.addMedia(media, quantity);
    }

    //Them san pham muon mua
    public void addBuyMedia(Media media, int quantity) throws NotEnoughQuantityException, InvalidQuantityException {
        cart.addBuyMedia(media, quantity);
    }

    //Xóa sản phẩm khỏi giỏ hàng
    public void removeMedia(Media media) {
        cart.removeMedia(media);
    }

    //Loại sản phẩm
    public void removeBuyMedia(Media media) {
        cart.removeBuyMedia(media);
    }

    //Bỏ hết sản phẩm đã chọn
    public void clearListBuyMedia() {
        cart.clearByCart();
    }
}
