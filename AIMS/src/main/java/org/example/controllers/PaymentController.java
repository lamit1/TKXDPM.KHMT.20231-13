package org.example.controllers;

import org.example.exceptions.AddressNotSupportRushDeliveryException;
import org.example.exceptions.NoRushMediaException;
import org.example.models.Cart;
import org.example.models.Invoice;
import org.example.models.Transaction;
import org.example.subsystem.VNPaySubsystem.VNPaySubsystem;

public class PaymentController{
    private Invoice invoice;

    //Data Coupling
    public Transaction makePayment(double amounts, String contents) {
        VNPaySubsystem subsystem = new VNPaySubsystem();
        Transaction transaction = subsystem.payOrder(amounts,contents);
        Transaction.saveTransaction(transaction);
        invoice.updateTransaction(transaction.getTransactionId());
        if (transaction.getAmount() == -1) {
            Invoice.updateStatus(transaction.getTransactionId(),"canceled");
        } else {
            Invoice.updateStatus(transaction.getTransactionId(),"paid");
        }
        emailToCustomer();
        clearCart();
        return transaction;
    }

    //Data Coupling
    private void clearCart() {
        invoice.clearCart();
    }


    private void emailToCustomer() {
        //TODO: Implement send email
    }


    //Data Coupling
    public double getTotalAmounts() throws AddressNotSupportRushDeliveryException, NoRushMediaException {
        return invoice.getTotalAmounts();
    }

    //Data Coupling
    public String getOrderContent() throws AddressNotSupportRushDeliveryException, NoRushMediaException {
        return "Paying for order " + invoice.getId() + " for " + (int)invoice.getTotalAmounts();
    }

    //Data Coupling
    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}
