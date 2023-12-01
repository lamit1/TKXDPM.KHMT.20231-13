package subsystem;

import entity.payment.PaymentTransaction;

public class VNPaySubsystem  implements IPayment {

    public VNPayManager manager;

    public VNPaySubsystem() {
        manager = new VNPayManager();
    }

    @Override
    public PaymentTransaction payOrder(double amounts, String content) {
        return manager.payOrder( amounts, content);
    }
}
