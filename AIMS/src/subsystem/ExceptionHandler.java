package subsystem;

import common.exception.CanceledPaymentException;
import entity.payment.PaymentTransaction;

/* Sử dụng đúng nguyên lý Single Responsibility bởi vì
lớp ExceptionHandler chỉ có duy nhất một nhiệm vụ là tạo handle Exception
Sai về nguyên lý Open Close vì như này sẽ không dễ dàng để mở rộng nếu có thay đổi
 */
public class ExceptionHandler {
    // Stamp coupling
    public void handle(Exception e, PaymentTransaction transaction) {
        if (e instanceof CanceledPaymentException) {
            transaction.setStatus("Failed!");
            transaction.setTransactionContent("Failed transaction because: " + e.getMessage());
        }
    }
}
