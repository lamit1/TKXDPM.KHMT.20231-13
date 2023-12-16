package subsystem;

import entity.payment.PaymentTransaction;


public interface IPayment {
    // Data coupling
    // Functional cohesion
    PaymentTransaction payOrder(double amounts, String content);
}
