package org.example.subsystem.VNPaySubsystem;

import com.google.gson.JsonObject;
import org.example.exceptions.CanceledPaymentException;
import org.example.exceptions.InvalidInputException;
import org.example.models.Transaction;
import org.example.subsystem.VNPaySubsystem.pay.PayRequest;
import org.example.subsystem.VNPaySubsystem.pay.Response;
import org.example.subsystem.VNPaySubsystem.refund.RefundRequest;
import org.example.subsystem.VNPaySubsystem.refund.RefundResponse;
import org.example.utils.API;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.text.ParseException;

public class VNPayManager {
    private VNPayView view= new VNPayView();
    private Validator validator = new Validator();

    private ExceptionHandler handler = new ExceptionHandler();

    public Transaction payOrder(double amounts, String content) {
        try {
            if (validator.validatePaymentInput(amounts, content)) {
                PayRequest payRequest = new PayRequest();
                String url = payRequest.createUrl(content, amounts);
                Response response = new Response(view.query(url));
                return response.getTransaction();
            }
        } catch (InvalidInputException | CanceledPaymentException | MalformedURLException |
                 UnsupportedEncodingException | ParseException e) {
            return handler.handleException(e);
        }
        return null;
    }

    public RefundResponse refund(String transactionId) {
        Transaction transaction = Transaction.findById(Integer.parseInt(transactionId));
        RefundRequest request = null;
        try {
            request = new RefundRequest(transaction);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        JsonObject jsonRequest = request.createJson();
        JsonObject jsonResponse = API.post(jsonRequest);
        return new RefundResponse().fromJson(String.valueOf(jsonResponse));
    }
}
