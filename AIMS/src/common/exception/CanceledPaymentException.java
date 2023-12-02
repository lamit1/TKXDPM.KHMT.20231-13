package common.exception;

public class CanceledPaymentException extends Exception{
    public CanceledPaymentException(String message) {
        super(message);
    }
}
