package subsystem;

import entity.payment.PaymentTransaction;

public interface IPayment {
    // Data coupling
    public PaymentTransaction payOrder(double amounts, String content);
}
