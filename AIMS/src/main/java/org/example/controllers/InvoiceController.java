package org.example.controllers;

import org.example.exceptions.AddressNotSupportRushDeliveryException;
import org.example.exceptions.NoRushMediaException;
import org.example.models.Invoice;
import org.example.models.Media;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InvoiceController {
    private Invoice invoice;

    //Data Coupling
    public List<HashMap<Media, Integer>> getMediaItems() {
        if (invoice == null) {
            return new ArrayList<>();
        }
        return invoice.getMediaItems();
    }

    //Data Coupling
    public double getCartAmounts() throws AddressNotSupportRushDeliveryException {
        if (invoice == null) return 0;
        try {
            return invoice.getTotalAmounts();
        } catch (NoRushMediaException e) {
            throw new RuntimeException(e);
        }
    }

    //Stamp Coupling
    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    //Stamp Coupling
    public Invoice getInvoice() {
        return invoice;
    }
}
