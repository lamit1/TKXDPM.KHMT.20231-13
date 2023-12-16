package entity.payment;

import java.util.Date;

/**
 * Thực hiện đúng Single Responsibility:
 * Thực hiện các lưu trữ dữ liệu của Transaction
 */
public class PaymentTransaction {
	private String transactionId;
	private String transactionContent;
	private double amount;
	private String createdAt;
	private String status;

	public PaymentTransaction() {
		this.createdAt = new Date().toString();
	}

	/**
	 * Functional cohesion
	 * @param transactionId
	 * @param transactionContent
	 * @param amount
	 * @param createdAt
	 */
	
	public PaymentTransaction(String transactionId, String transactionContent,
			double amount, String createdAt) {
		this.transactionId = transactionId;
		this.transactionContent = transactionContent;
		this.amount = amount;
		this.createdAt = createdAt;
	}

	public String getTransactionContent() {
		return transactionContent;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setTransactionContent(String transactionContent) {
		this.transactionContent = transactionContent;
	}
}
