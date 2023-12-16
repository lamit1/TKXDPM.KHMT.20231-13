package entity.order;

import java.util.HashMap;

import entity.cart.Cart;

/**
 * Thực hiện đúng Single Responsibility:
 * Thực hiện các lưu trữ dữ liệu của Order
 */
public class Order {
    private int shippingFees;
    private HashMap<String, String> deliveryInfo;
    /**
     * All function here are all communicational cohesion
     * because all are used for purpose get order media information
     */
    public void setShippingFees(int shippingFees) {
        this.shippingFees = shippingFees;
    }

    public int getShippingFees() {
        return shippingFees ;
    }

    public HashMap getDeliveryInfo() {
        return deliveryInfo;
    }

    public void setDeliveryInfo(HashMap deliveryInfo) {
        this.deliveryInfo = deliveryInfo;
    }

    public int getOrderAmount(){
        return Cart.getCart().calSubtotal() + shippingFees;
    }

}
