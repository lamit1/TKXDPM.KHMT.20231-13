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

    public List<HashMap<Media, Integer>> getMediaItems() {
        if (invoice == null) {
            return new ArrayList<>();
        }
        return invoice.getMediaItems();
    }

    public double getCartAmounts() throws AddressNotSupportRushDeliveryException {
        if (invoice == null) return 0;
        try {
            return invoice.getTotalAmounts();
        } catch (NoRushMediaException e) {
            throw new RuntimeException(e);
        }
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Invoice getInvoice() {
        return invoice;
    }
}
