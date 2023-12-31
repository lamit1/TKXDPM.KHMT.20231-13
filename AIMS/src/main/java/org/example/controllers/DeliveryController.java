package org.example.controllers;

import org.example.exceptions.AddressNotSupportRushDeliveryException;
import org.example.exceptions.NoMediaInCartException;
import org.example.exceptions.NoRushMediaException;
import org.example.models.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class DeliveryController {
    private Order order = new Order();

    public void setDelivery(Delivery delivery) {
        order.setDelivery(delivery);
    }

    public Invoice saveInvoice(Order order) throws SQLException, ClassNotFoundException {
        return Invoice.saveInvoice(order);
    }
    public Order saveOrder(Delivery delivery) {
        return order.saveOrder(delivery);
    }

    public boolean validateForm(Delivery d) {
        return true;
    }
    public boolean checkRushDeliverySupport() throws NoRushMediaException {
        return Cart.getCart().isRushDeliverySupport();
    }

    public boolean checkCartEmpty() {
        return Cart.getCart().isCartEmpty();
    }

    public double getCartAmounts() {
        return order.getCartAmounts();
    }

    public double getShipAmounts() throws AddressNotSupportRushDeliveryException, NoMediaInCartException, NoRushMediaException {
        if (order.isRushDelivery()) return order.getRushShipAmounts();
        return order.getShipAmounts();
    }
    public double getTotalAmounts() throws AddressNotSupportRushDeliveryException, NoRushMediaException {
        return order.getTotalAmounts();
    }



    public void saveDelivery(Delivery delivery) throws SQLException, ClassNotFoundException {
        if(delivery.isRushDelivery()) {
            Delivery.saveDelivery(delivery);
        } else {
            RushDelivery.saveDelivery(delivery);
        }
    }

    public Order getOrder() {
        return order;
    }

}