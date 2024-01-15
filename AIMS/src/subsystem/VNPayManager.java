package subsystem;

import entity.payment.PaymentTransaction;

public class VNPayManager {
    private VNPayView view;
    private Validator validator;

    public VNPayManager() {
        view = new VNPayView();
        validator =  new Validator();
    }
    // Functional cohesion
    public PaymentTransaction payOrder(double amounts, String content) {
        try {
            /*
             * Data coupling
             */
            if (validator.validate(amounts, content)) {
                Request request = new Request();
                /*
                  Data coupling
                 */
                String url = request.createUrl(content, amounts);
                /*
                  Data coupling
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
