package controller;

import entity.cart.Cart;
import entity.invoice.Invoice;
import entity.order.Order;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Random;
import java.util.logging.Logger;

/**
 * This class controls the flow of place order usecase in our AIMS project
 * @author nguyenlm
 */
public class PlaceOrderController extends BaseController{

    /**
     * Just for logging purpose
     */
    private static Logger LOGGER = utils.Utils.getLogger(PlaceOrderController.class.getName());

    /**
     * This method checks the avalibility of product when user click PlaceOrder button
     * @throws SQLException
     */
    //no coupling
    public void placeOrder() throws SQLException{
        Cart.getCart().checkAvailabilityOfProduct();
    }

    /**
     * This method creates the new Order based on the Cart
     * @return Order
     * @throws SQLException
     */

    //no coupling
    //Coincedential cohesion
    public Order createOrder() throws SQLException{
        return new Order();
    }

    /**
     * This method creates the new Invoice based on order
     * @param order
     * @return Invoice
     */

    // Data coupling
    // coincidental cohesion
    public Invoice createInvoice(Order order) {
        return new Invoice(order);
    }

    /**
     * This method takes responsibility for processing the shipping info from user
     * @param info
     * @throws InterruptedException
     * @throws IOException
     */
    //no coupling
    //Coincedential cohesion
    public void processDeliveryInfo(HashMap info) throws InterruptedException, IOException{
        LOGGER.info("Process Delivery Info");
        LOGGER.info(info.toString());
        validateDeliveryInfo(info);
    }

    /**
   * The method validates the info
   * @param info
   * @throws InterruptedException
   * @throws IOException
   */

    //no coupling
    //Procedural cohesion
    public void validateDeliveryInfo(HashMap<String, String> info) throws InterruptedException, IOException{

    }

    //no coupling
    //coincidental cohesion
    public boolean validatePhoneNumber(String phoneNumber) {
    	// TODO: your work
    	return false;
    }
    //no coupling
    //coincidental cohesion
    public boolean validateName(String name) {
    	// TODO: your work
    	return false;
    }
    //coincidental cohesion
    // no coupling
    public boolean validateAddress(String address) {
    	// TODO: your work
    	return false;
    }


    /**
     * This method calculates the shipping fees of order
     * @param order
     * @return shippingFee
     */

    //stamp coupling
    //coincidental cohesion
    public int calculateShippingFee(Order order){
        Random rand = new Random();
        int fees = (int)( ( (rand.nextFloat()*10)/100 ) * order.getOrderAmount() );
        LOGGER.info("Order Amount: " + order.getOrderAmount() + " -- Shipping Fees: " + fees);
        return fees;
    }
}
