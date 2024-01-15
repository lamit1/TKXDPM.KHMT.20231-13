package entity.invoice;

import entity.order.Order;

public class Invoice {

    private Order order;
    private int amount;
    
    public Invoice(){

    }
    /**
     * All function here are all communicational cohesion
     * because all are used for purpose get invoice information
     */
    public Invoice(Order order){
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void saveInvoice(){
        
    }
}
