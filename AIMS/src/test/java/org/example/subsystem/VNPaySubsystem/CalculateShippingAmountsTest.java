package org.example.subsystem.VNPaySubsystem;
import org.example.controllers.DeliveryController;
import org.example.models.*;
import org.example.exceptions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;
public class CalculateShippingAmountsTest {
    private static Cart cart;
    private static Delivery hanoiDelivery;
    private static Delivery langsonDelivery;
    private static RushDelivery hanoiRushDelivery;
    private static RushDelivery langSonRushDelivery;

    private static Media mediaSupportRush;
    private static Media mediaNormal;
    @BeforeAll
    static void setup() throws InvalidQuantityException, NotEnoughQuantityException {
        cart = Cart.getCart();
        mediaSupportRush = new Media(1, "Book1",10000,true, 2.0, 10, "image_link", "Book" );
        mediaNormal = new Media(1, "Book1",20000,false, 2.0, 30, "image_link", "Book" );
        cart.addMedia(mediaSupportRush,1);
        cart.addMedia(mediaNormal,2);
        hanoiDelivery = new Delivery("Nguyen Van A","0912335151","example@gmail.com","Hà Nội","2 Tạ Quang Bửu","");
        hanoiRushDelivery = new RushDelivery("Nguyen Van A","0912335151","Hà Nội","","2 Tạ Quang Bửu","",new Timestamp(System.currentTimeMillis()).toString(),"Số 1 Đại Cồ Việt");
        langsonDelivery = new Delivery("Nguyen Van A","0912335151","example@gmail.com","Lạng Sơn","2 Tạ Quang Bửu","");
        langSonRushDelivery = new RushDelivery("Nguyen Van A","0912335151","Lạng Sơn","","2 Tạ Quang Bửu","", new Timestamp(System.currentTimeMillis()).toString(),"Số 1 Đại Cồ Việt");
    }
    @Test
    void calculateShippingWithMoreThan100KAmounts() throws InvalidQuantityException, NotEnoughQuantityException {
        cart.clearCart();
        cart.addMedia(mediaNormal, 10);
        assertTrue( new Order(hanoiDelivery).getShipAmounts()==0);
    }
    @Test
    void calculateHanoiShippingAmountWithNormalDelivery() throws InvalidQuantityException, NotEnoughQuantityException {
        cart.clearCart();
        cart.addMedia(mediaNormal, 3);
        assertEquals(52000f, new Order(hanoiDelivery).getShipAmounts());
    }
    @Test
    void calculateLangSonShippingAmountWithNormalDelivery() throws InvalidQuantityException, NotEnoughQuantityException {
        cart.clearCart();
        cart.addMedia(mediaNormal, 3);
        assertEquals(93000, new Order(langsonDelivery).getShipAmounts());
    }
    @Test
    void calculateHanoiShippingAmountWithRushDelivery() throws InvalidQuantityException, NotEnoughQuantityException, AddressNotSupportRushDeliveryException, NoRushMediaException {
        cart.clearCart();
        cart.addMedia(mediaSupportRush, 3);
        assertEquals(67000f, new Order(hanoiRushDelivery).getRushShipAmounts());
    }
    @Test
    void calculateLangSonShippingAmountWithRushDelivery() {
        Order order = new Order(langSonRushDelivery);
        assertThrows(
                AddressNotSupportRushDeliveryException.class,
                () -> order.getRushShipAmounts()
        );
    }
    @Test
    void calculateShippingNormalMediaWithRushDelivery() throws InvalidQuantityException, NotEnoughQuantityException {
        cart.clearCart();
        cart.addMedia(mediaNormal, 3);
        assertThrows(NoRushMediaException.class,
                ()->new Order(hanoiRushDelivery).getRushShipAmounts());
    }
}
