package controller;

import entity.cart.Cart;
import entity.payment.PaymentTransaction;
import subsystem.IPayment;
import subsystem.VNPaySubsystem;


/**
 * This {@code PaymentController} class control the flow of the payment process
 * in our AIMS Software.
 *
 * @author hieud
 *
 */
public class PaymentController extends BaseController {
	/**
	 * Represent the Interbank subsystem
	 */
	private IPayment interbank = new VNPaySubsystem();

	/**
	 * Pay order, and then return the result with a message.
	 *
	 * @param amount   - the amount to pay
	 * @param contents - the transaction contents
	 * @return {@link java.util.Map Map} represent the payment result with a
	 * message.
	 */
	// no coupling
	public PaymentTransaction payOrder(double amount, String contents) {
		return interbank.payOrder(amount, contents);
	}
	//no coupling
	//Temporal cohesion
	public void emptyCart(){
        Cart.getCart().emptyCart();
    }
}
