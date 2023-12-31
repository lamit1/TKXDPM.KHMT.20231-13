package org.example.subsystem.VNPaySubsystem;

import org.example.exceptions.CanceledPaymentException;
import org.example.exceptions.InvalidInputException;
import org.example.models.Transaction;
import org.example.subsystem.IPayment;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.text.ParseException;

public class VNPaySubsystem  implements IPayment {
    @Override
    public void refund(Transaction transaction) {
        return;
    }

    public VNPayManager manager;

    public VNPaySubsystem() {
        manager = new VNPayManager();
    }

    @Override
    public Transaction payOrder( double amounts, String content) {
        return manager.payOrder( amounts, content);
    }
}
