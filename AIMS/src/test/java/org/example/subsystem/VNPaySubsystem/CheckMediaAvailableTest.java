package java.org.example.subsystem.VNPaySubsystem;

import org.example.models.Cart;
import org.example.models.Media;
import org.example.exceptions.InvalidQuantityException;
import org.example.exceptions.NotEnoughQuantityException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CheckMediaAvailableTest {
    private static Cart cart;
    private static Media mediaWith0Available;
    private static Media mediaWith3Available;

    @BeforeAll
    static void setup() {
        cart = Cart.getCart();
        mediaWith0Available = new Media(1, "Book1",10000,true, 2.0, 1, "image_link", "Book" );

        mediaWith3Available = new Media(1, "Book1",10000,true, 2.0, 3, "image_link", "Book" );

    }
    @Test
    void AddMediaNotEnoughAvailable() {
        String message = assertThrows(NotEnoughQuantityException.class, ()->{
            cart.addMedia(mediaWith0Available, 2);
        }).getMessage();
        assertEquals(message, "There are only " + mediaWith0Available.getAvailable() + " available. You ask " + 2);
    }
    @Test
    void AddMediaEnoughAvailable() {
        assertDoesNotThrow(()->cart.addMedia(mediaWith3Available, 2));
    }
    @Test
    void AddMediaInvalidQuantity() {
        String message = assertThrows(InvalidQuantityException.class, ()->{
            cart.addMedia(mediaWith3Available, -2);
        }).getMessage();
        assertEquals(message, "Invalid quantity!");
    }
}
