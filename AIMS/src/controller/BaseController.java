package controller;

import java.util.List;

import entity.cart.Cart;
import entity.media.QuantityMedia;
import entity.media.Media;

/**
 * This class is the base controller for our AIMS project
 * @author nguyenlm
 */
public class BaseController {
    
    /**
     * The method checks whether the Media in Cart, if it were in, we will return the CartMedia else return null
     * @param media
     * @return CartMedia or null
     */

    //data coupling
    //coincidental cohesion vì độc lập chức năng với getListCartMedia
    public QuantityMedia checkMediaInCart(Media media){
        return Cart.getCart().checkMediaInCart(media);
    }

    /**
     * This method gets the list of items in cart
     * @return List[CartMedia]
     */
    //coincidental cohesion vì độc lập chức năng với checkMediaCart
    //no coupling
    public List getListCartMedia(){
        return Cart.getCart().getListMedia();
    }
}
