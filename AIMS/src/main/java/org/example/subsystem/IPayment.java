package org.example.subsystem;

import org.example.models.Transaction;

public interface IPayment {
    public Transaction payOrder( double amounts, String content);
}
