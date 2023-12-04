package subsystem;

import common.exception.InvalidInputException;

import java.util.regex.Pattern;

public class Validator {
    // Functional cohesion
    public boolean validate(double amounts, String content) throws InvalidInputException {
        if (amounts >= 5000) {
            if(Pattern.compile("^[0-9a-zA-Z]*$").matcher(content).matches()) {
                return true;
            } else {
                throw new InvalidInputException( content + " have invalid character!");
            }
        } else {
            throw new InvalidInputException(amounts + " is less than 5000!");
        }
    }
}
