package subsystem;

import common.exception.InvalidInputException;

import java.util.regex.Pattern;


/* Sử dụng đúng nguyên lý Single Responsibility bởi vì
lớp Validator chỉ có duy nhất một nhiệm vụ là tạo validate content
Sai về nguyên lý Open Close vì như này sẽ không dễ dàng để mở rộng nếu có thay đổi
 */

public class Validator {
    // No cohesion
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
