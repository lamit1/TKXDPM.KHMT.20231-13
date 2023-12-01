package controller;

import java.util.Calendar;
import java.util.Hashtable;
import java.util.Map;

import common.exception.CanceledPaymentException;
import common.exception.InvalidCardException;
import common.exception.PaymentException;
import common.exception.UnrecognizedException;
import entity.cart.Cart;
import entity.payment.CreditCard;
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
	 * Represent the card used for payment
	 */
	private CreditCard card;

	/**
	 * Represent the Interbank subsystem
	 */
	private IPayment iPayment;

	/**
	 * Validate the input date which should be in the format "mm/yy", and then
	 * return a {@link java.lang.String String} representing the date in the
	 * required format "mmyy" .
	 * 
	 * @param date - the {@link java.lang.String String} represents the input date
	 * @return {@link java.lang.String String} - date representation of the required
	 *         format
	 * @throws InvalidCardException - if the string does not represent a valid date
	 *                              in the expected format
	 */
	private String getExpirationDate(String date) throws InvalidCardException {
		String[] strs = date.split("/");
		if (strs.length != 2) {
			throw new InvalidCardException();
		}

		String expirationDate = null;
		int month = -1;
		int year = -1;

		try {
			month = Integer.parseInt(strs[0]);
			year = Integer.parseInt(strs[1]);
			if (month < 1 || month > 12 || year < Calendar.getInstance().get(Calendar.YEAR) % 100 || year > 100) {
				throw new InvalidCardException();
			}
			expirationDate = strs[0] + strs[1];

		} catch (Exception ex) {
			throw new InvalidCardException();
		}

		return expirationDate;
	}

	/**
	 * Pay order, and then return the result with a message.
	 * 
	 * @param amount         - the amount to pay
	 * @param contents       - the transaction contents
	 * @return {@link java.util.Map Map} represent the payment result with a
	 *         message.
	 *
	 */
	public Map<String, String> payOrder(int amount, String contents) {
		Map<String, String> result = new Hashtable<String, String>();
		result.put("RESULT", "PAYMENT FAILED!");
		try {
			this.iPayment = new VNPaySubsystem();
			PaymentTransaction transaction = iPayment.payOrder(100000, "contents");
			if (transaction != null) {
				result.put("RESULT", "PAYMENT SUCCESSFUL!");
				result.put("MESSAGE", "You have succesffully paid the order!");
			}
			throw new CanceledPaymentException("Payment was canceled");
		} catch (PaymentException | UnrecognizedException | CanceledPaymentException ex) {
			result.put("MESSAGE", ex.getMessage());
		}
        return result;
	}

	public void emptyCart(){
        Cart.getCart().emptyCart();
    }
}