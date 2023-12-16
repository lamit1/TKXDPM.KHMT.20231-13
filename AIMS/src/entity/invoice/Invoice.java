package entity.invoice;

import entity.order.Order;
/**
 * Thực hiện đúng Single Responsibility:
 * Thực hiện các lưu trữ dữ liệu của DVD
 */
public class Invoice {

    private Order order;
    private int amount;

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

    public void saveInvoice(){
        
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
