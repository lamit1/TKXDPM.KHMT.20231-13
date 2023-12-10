package entity.payment;

public class PaymentTransaction {
	private String transactionId;
	private String transactionContent;
	private double amount;
	private String createdAt;

	/**
	 * Functional cohesion
	 * @param transactionId
	 * @param transactionContent
	 * @param amount
	 * @param createdAt
	 */
	
	public PaymentTransaction(String transactionId, String transactionContent,
			double amount, String createdAt) {
		super();
		this.transactionId = transactionId;
		this.transactionContent = transactionContent;
		this.amount = amount;
		this.createdAt = createdAt;
	}
}
