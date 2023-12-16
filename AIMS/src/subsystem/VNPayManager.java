package subsystem;

import entity.payment.PaymentTransaction;


/*
Vi phạm nguyên lý Dependency Inversion và Open-Close
VNPayManager nên phụ thuộc vào các lớp trừu tượng để có thể dễ dàng maintain code hơn
VNpayView, Validator và ExceptionHandler đều là các lớp cụ thể
 */

public class VNPayManager {
    private VNPayView view;
    private Validator validator;
    private ExceptionHandler exceptionHandler;

    public VNPayManager() {
        view = new VNPayView();
        validator =  new Validator();
        exceptionHandler = new ExceptionHandler();
    }
    // Functional cohesion
    public PaymentTransaction payOrder(double amounts, String content) {
        PaymentTransaction transaction = new PaymentTransaction();
        try {
            /*
             * Data coupling
             */
            if (validator.validate(amounts, content)) {
                /*
                  Data coupling
                 */
                String url = new Request().createUrl(content, amounts);
                /*
                  Data coupling
                 */
                String responseString = view.query(url);
                Response response = new Response(responseString);
                transaction = response.getTransaction();
            }
        } catch (Exception e) {
            // Stamp coupling
            exceptionHandler.handle(e, transaction);
        }
        return transaction;
    }
}
