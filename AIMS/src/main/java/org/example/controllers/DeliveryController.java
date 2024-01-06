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

    //Data Coupling
    //Functional cohesion
    public void setDelivery(Delivery delivery) {
        order.setDelivery(delivery);
    }

    //Data Coupling
    //Coincidental cohesion
    public Invoice saveInvoice(Order order) throws SQLException, ClassNotFoundException {
        return Invoice.saveInvoice(order);
    }

    //Data Coupling
    //Functional cohesion
    public Order saveOrder(Delivery delivery) {
        return order.saveOrder(delivery);
    }


    //Stamp Coupling
    //Coincidental cohesion
    public boolean validateForm(Delivery d) {
        return true;
    }
    public boolean checkRushDeliverySupport() throws NoRushMediaException {
        return Cart.getCart().isRushDeliverySupport();
    }

    //Data Coupling
    //Coincidental cohesion
    public boolean checkCartEmpty() {
        return Cart.getCart().isCartEmpty();
    }

    //Data Coupling
    //Functional cohesion
    public double getCartAmounts() {
        return order.getCartAmounts();
    }

    //Stamp Coupling
    //Functional cohesion
    public double getShipAmounts() throws AddressNotSupportRushDeliveryException, NoMediaInCartException, NoRushMediaException {
        if (order.isRushDelivery()) return order.getRushShipAmounts();
        return order.getShipAmounts();
    }

    //Stamp coupling
    //Functional cohesion
    public double getTotalAmounts() throws AddressNotSupportRushDeliveryException, NoRushMediaException {
        return order.getTotalAmounts();
    }



    public void saveDelivery(Delivery delivery) throws SQLException, ClassNotFoundException {
        if(delivery.isRushDelivery()) {
            RushDelivery.saveDelivery(delivery);
        } else {
            Delivery.saveDelivery(delivery);
        }
    }

    public Order getOrder() {
        return order;
    }

}
