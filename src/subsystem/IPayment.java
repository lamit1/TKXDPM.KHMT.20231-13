package subsystem;

import entity.payment.PaymentTransaction;

public interface IPayment {
    public PaymentTransaction payOrder(double amounts, String content);
}
