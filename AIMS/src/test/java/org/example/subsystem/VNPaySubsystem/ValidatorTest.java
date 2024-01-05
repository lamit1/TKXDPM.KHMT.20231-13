package org.example.subsystem.VNPaySubsystem;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.example.controllers.OrderController;
import org.example.subsystem.VNPaySubsystem.Validator;
import org.junit.Test;

public class ValidatorTest {

    private OrderController controller = new OrderController();
    @Test
    public void testValidatePhoneNumber_ValidNumbers() {
        // Valid phone numbers
        assertTrue("Valid number starting with 09 and 11 digits", controller.validatePhoneNumber("09123456789"));
        assertTrue("Valid number starting with 08 and 11 digits", controller.validatePhoneNumber("08123456789"));
        assertTrue("Valid number starting with 09 and 9 digits", controller.validatePhoneNumber("091234567"));
        assertTrue("Valid number starting with 08 and 9 digits", controller.validatePhoneNumber("081234567"));
    }

    @Test
    public void testValidatePhoneNumber_InvalidNumbers() {
        // Invalid phone numbers
        assertFalse("Invalid number not starting with 08 or 09", controller.validatePhoneNumber("07123456789"));
        assertFalse("Invalid number with less than 9 digits", controller.validatePhoneNumber("09123456"));
        assertFalse("Invalid number with more than 11 digits", controller.validatePhoneNumber("0912345678910"));
        assertFalse("Invalid number with non-numeric characters", controller.validatePhoneNumber("091234567a9"));
        assertFalse("Invalid number with spaces", controller.validatePhoneNumber("09123 456789"));
        assertFalse("Invalid empty string", controller.validatePhoneNumber(""));
        assertFalse("Invalid null input", controller.validatePhoneNumber(null));
    }

    // Add more tests if needed for edge cases
}
