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
            if (validator.validate(amounts, content)) {
                Request request = new Request();
                String url = request.createUrl(content, amounts);
                Response response = new Response(view.query(url));
                return response.getTransaction();
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return null;
    }
}
