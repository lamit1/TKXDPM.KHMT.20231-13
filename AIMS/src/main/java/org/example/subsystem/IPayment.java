package org.example.subsystem;

import org.example.models.Transaction;
import org.example.subsystem.VNPaySubsystem.refund.RefundResponse;

public interface IPayment {
    public Transaction payOrder( double amounts, String content);

    public RefundResponse refund(String transactionId);
}
