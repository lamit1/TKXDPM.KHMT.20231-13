package java.org.example.subsystem.VNPaySubsystem;

import org.example.models.*;
import org.example.exceptions.InvalidQuantityException;
import org.example.exceptions.NoMediaInCartException;
import org.example.exceptions.NotEnoughQuantityException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculateCartAmountsTest {
    private Cart cart = Cart.getCart();
    private static Media mediaNormal;
    private Order order;
    @BeforeAll
    static void setup() {
        mediaNormal = new Media(1, "Book1",20000,false, 2.0, 30, "image_link", "Book" );
  }

    @Test
    void getCartAmountsWithNoMedia() {
        cart.clearCart();
        assertThrows(NoMediaInCartException.class, ()->cart.getCartAmounts());
    }

    @Test
    void getCartAmountsSuccess() throws InvalidQuantityException, NotEnoughQuantityException {
        cart.addMedia(mediaNormal,2);
        try {
            assertEquals( 40000f,cart.getCartAmounts());
        } catch (NoMediaInCartException e) {
            throw new RuntimeException(e);
        }
    }
}
