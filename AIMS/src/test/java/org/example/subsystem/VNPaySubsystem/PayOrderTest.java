package java.org.example.subsystem.VNPaySubsystem;

import org.example.models.Transaction;
import org.example.exceptions.CanceledPaymentException;
import org.example.exceptions.InvalidInputException;
import org.example.subsystem.VNPaySubsystem.Validator;
import org.example.subsystem.VNPaySubsystem.pay.Response;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import static org.junit.Assert.*;

public class PayOrderTest {

    private static Transaction successTransaction;
    private static final Validator validator = new Validator();
    private static final double numLessThan5000 = 4000;
    private static final double numMoreThan5000 = 6000;
    private static final double numEqual5000 = 5000;
    private static final String contentHaveSpecialChar = "ABC$$!@#!@%!@";
    private static final String contentNotHaveSpecialChar = "A1Cb";

    @BeforeAll
    static void setup() {
        Calendar cld = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        successTransaction = new Transaction((long) 10000, "TestTransaction", new Timestamp(cld.getTime().getTime()));
    }
    @Test
    public void ValidateAmountLessThan5000AndContentNotHaveSpecialChar(){
        String message = assertThrows(
                InvalidInputException.class,
                ()->validator.validatePaymentInput(numLessThan5000, contentNotHaveSpecialChar)
        ).getMessage();
        assertEquals(message, numLessThan5000 + " is less than 5000!");
    }
    @Test
    public void ValidateAmountEqual5000AndContentNotHaveSpecialChar(){
        try {
            assertTrue(validator.validatePaymentInput(numEqual5000,contentNotHaveSpecialChar));
        } catch (InvalidInputException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void ValidateAmountMoreThan5000AndContentNotHaveSpecialChar(){
        try {
            assertTrue(validator.validatePaymentInput(numMoreThan5000,contentNotHaveSpecialChar));
        } catch (InvalidInputException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void ValidateAmountMoreThan5000AndContentHaveSpecialChar(){
        String message = assertThrows(
                InvalidInputException.class,
                ()->validator.validatePaymentInput(numMoreThan5000, contentHaveSpecialChar)
        ).getMessage();
        assertEquals(message, contentHaveSpecialChar + " have invalid character!");
    }
    @Test
    public void ValidateAmountEqual5000AndContentHaveSpecialChar() {
        String message = assertThrows(
                InvalidInputException.class,
                ()->validator.validatePaymentInput(numEqual5000, contentHaveSpecialChar)
        ).getMessage();
    }
    @Test
    public void ValidateAmountLessThan5000AndContentHaveSpecialChar() {
        String message = assertThrows(
                InvalidInputException.class,
                ()->validator.validatePaymentInput(numLessThan5000, contentNotHaveSpecialChar)
        ).getMessage();
        assertEquals(message, numLessThan5000+ " is less than 5000!");
    }

    @Test
    public void GetTransactionWithNullURL() {
        String message = assertThrows(
                CanceledPaymentException.class,
                ()->new Response("").getTransaction()).getMessage();
        assertEquals(message , "Not follow enough paying step!");
    }


    @Test
    public void GetTransactionWithCanceledPaymentURL() {
        String message = assertThrows(
                CanceledPaymentException.class,
                ()->new Response("http://localhost:9999/web/vnpay_return.jsp" +
                        "?vnp_Amount=1000000" +
                        "&vnp_BankCode=NCB" +
                        "&vnp_BankTranNo=20170829152730" +
                        "&vnp_CardType=ATM" +
                        "&vnp_OrderInfo=TestTransaction" +
                        "&vnp_PayDate=20170829153052" +
                        "&vnp_ResponseCode=24" +
                        "&vnp_TmnCode=2QXUI4J4" +
                        "&vnp_TransactionNo=12996460" +
                        "&vnp_TxnRef=23597" +
                        "&vnp_SecureHashType=SHA256" +
                        "&vnp_SecureHash=20081f0ee1cc6b524e273b6d4050fefd").getTransaction()).getMessage();
        assertEquals(message , "Payment was canceled!");
    }

    @Test
    public void GetTransactionWithSuccessPaymentURL() throws MalformedURLException {
        try {
            assertEquals(new Response(
                    "http://localhost:9999/web/vnpay_return.jsp" +
                            "?vnp_Amount=1000000" +
                            "&vnp_BankCode=NCB" +
                            "&vnp_BankTranNo=20170829152730" +
                            "&vnp_CardType=ATM" +
                            "&vnp_OrderInfo=TestTransaction" +
                            "&vnp_PayDate=20170829153052" +
                            "&vnp_ResponseCode=00" +
                            "&vnp_TmnCode=2QXUI4J4" +
                            "&vnp_TransactionNo=12996460" +
                            "&vnp_TxnRef=23597" +
                            "&vnp_SecureHashType=SHA256" +
                            "&vnp_SecureHash=20081f0ee1cc6b524e273b6d4050fefd")
                    .getTransaction(), successTransaction);
        } catch (CanceledPaymentException | UnsupportedEncodingException | ParseException e) {
            throw new RuntimeException(e);
        }
    }
}