package org.example.subsystem.VNPaySubsystem;

import org.example.models.Transaction;
import org.example.subsystem.IPayment;
import org.example.subsystem.VNPaySubsystem.refund.RefundResponse;

public class VNPaySubsystem  implements IPayment {
    @Override
    public RefundResponse refund(String transactionId) {
        // Data coupling
        return manager.refund(transactionId);
    }

    public VNPayManager manager= new VNPayManager();


    @Override
    public Transaction payOrder( double amounts, String content) {
        // Data coupling
        return manager.payOrder( amounts, content);
    }
}
