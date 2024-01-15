package controller;

import entity.cart.Cart;

import java.sql.SQLException;

/**
 * This class controls the flow of events when users view the Cart
 * @author nguyenlm
 */
public class ViewCartController extends BaseController{

    /**
     * This method checks the available products in Cart
     * @throws SQLException
     */
    //no coupling
    //coincidental cohesion
    public void checkAvailabilityOfProduct() throws SQLException{
        Cart.getCart().checkAvailabilityOfProduct();
    }

    /**
     * This method calculates the cart subtotal
     * @return subtotal
     */
    //no coupling
    //coincidental cohesion
    public int getCartSubtotal(){
        int subtotal = Cart.getCart().calSubtotal();
        return subtotal;
    }

}
