package subsystem;

import entity.payment.PaymentTransaction;

public class VNPaySubsystem  implements IPayment {

    public VNPayManager manager;

    public VNPaySubsystem() {
        manager = new VNPayManager();
    }

    // Coincidental cohesion
    @Override
    public PaymentTransaction payOrder(double amounts, String content) {
        /**
         * Content coupling
         */
        return manager.payOrder( amounts, content);
    }
}
