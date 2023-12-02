package subsystem;

import entity.payment.PaymentTransaction;

public class VNPayManager {
    private VNPayView view;
    private Validator validator;

    public VNPayManager() {
        view = new VNPayView();
        validator =  new Validator();
    }
    public PaymentTransaction payOrder(double amounts, String content) {
        try {
            /*
             * Content coupling
             */
            if (validator.validate(amounts, content)) {
                Request request = new Request();
                /*
                  Content coupling
                 */
                String url = request.createUrl(content, amounts);
                /*
                  Content coupling
                 */
                String responseString = view.query(url);
                Response response = new Response(responseString);
                return response.getTransaction();
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return null;
    }
}
