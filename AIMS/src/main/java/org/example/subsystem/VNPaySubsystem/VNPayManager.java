package org.example.subsystem.VNPaySubsystem;

import org.example.exceptions.CanceledPaymentException;
import org.example.exceptions.InvalidInputException;
import org.example.models.Transaction;
import org.example.subsystem.ExceptionHandler;
import org.example.subsystem.Request;
import org.example.subsystem.Response;
import org.example.subsystem.Validator;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.text.ParseException;

public class VNPayManager {
    private VNPayView view;
    private Validator validator;

    private ExceptionHandler handler = new ExceptionHandler();

    public VNPayManager() {
        view = new VNPayView();
        validator =  new Validator();
    }
    public Transaction payOrder(double amounts, String content) {
        try {
            if (validator.validate(amounts, content)) {
                Request request = new Request();
                String url = request.createUrl(content, amounts);
                Response response = new Response(view.query(url));
                return response.getTransaction();
            }
        } catch (InvalidInputException | CanceledPaymentException | MalformedURLException |
                 UnsupportedEncodingException | ParseException e) {
            return handler.handleException(e);
        }
        return null;
    }
}