package subsystem;

import entity.payment.PaymentTransaction;

public interface IPayment {
    // Data coupling
    // Functional cohesion
    public PaymentTransaction payOrder(double amounts, String content);
}
