package org.example.subsystem.VNPaySubsystem;

import org.example.exceptions.CanceledPaymentException;
import org.example.models.Transaction;

import java.beans.ExceptionListener;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;

public class ExceptionHandler {
    public ExceptionHandler() {

    }

    public Transaction handleException(Exception e) {
        if (e instanceof CanceledPaymentException) {
            return new Transaction(-1, "Payment was canceled", Timestamp.from(Instant.now()));
        }
        return null;
    }
}
