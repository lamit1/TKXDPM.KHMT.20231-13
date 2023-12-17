package subsystem;

import entity.payment.PaymentTransaction;

public class VNPaySubsystem  implements IPayment {
    // Functional cohesion
    public VNPayManager manager = new VNPayManager();
    @Override
    public PaymentTransaction payOrder(double amounts, String content) {
        /**
         * Content coupling
         */
        return manager.payOrder( amounts, content);
    }
}
