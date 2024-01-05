package org.example.subsystem.VNPaySubsystem;

import org.example.exceptions.InvalidInputException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public boolean validatePaymentInput(double amounts, String content) throws InvalidInputException {
        if (amounts >= 5000) {
            if(Pattern.compile("^[a-zA-Z0-9 ]*$").matcher(content).matches()) {
                return true;
            } else {
                throw new InvalidInputException( content + " have invalid character!");
            }
        } else {
            throw new InvalidInputException(amounts + " is less than 5000!");
        }
    }



}
