package subsystem;

import common.exception.CanceledPaymentException;
import common.exception.PaymentException;
import common.exception.UnrecognizedException;
import config.Config;
import entity.payment.PaymentTransaction;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/* Sử dụng đúng nguyên lý Single Responsibility bởi vì
 lớp Response chỉ có duy nhất một nhiệm vụ là tạo get Transaction
Vi phạm nguyên lý Open Close vì lớp Response hiện tại chỉ có thể
phục vụ duy nhất cho VNPay
 */
public class Response {
    private String id;
    private String contents;
    private String responseCode;
    private double amounts;
    private String payTime;
    //Func
    public Response(String responseString) throws CanceledPaymentException, UnsupportedEncodingException, MalformedURLException, ParseException {
        /**
         * Common couping with Config class
         */
        if (!responseString.startsWith(Config.vnp_ReturnUrl)){
            throw new CanceledPaymentException("Not follow enough paying step!");
        }
        Map<String, String> parameters = new HashMap<>();
        URL urlObject = new URL(responseString);
        String query = urlObject.getQuery();
        String[] paramPairs = query.split("&");
        for (String paramPair : paramPairs) {
            String[] keyValue = paramPair.split("=");
            if (keyValue.length == 2) {
                String key = URLDecoder.decode(keyValue[0], "UTF-8");
                String value = URLDecoder.decode(keyValue[1], "UTF-8");
                parameters.put(key, value);
            }
        }
        id = parameters.get("vnp_TransactionNo");
        amounts = Double.parseDouble(parameters.get("vnp_Amount"))/100;
        responseCode =  parameters.get("vnp_ResponseCode");
        contents = parameters.get("vnp_OrderInfo");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Date parsedDate = dateFormat.parse(parameters.get("vnp_PayDate"));
        payTime = new Timestamp(parsedDate.getTime()).toString();
    }

    /** Functional cohesion with Response(responseString)
     *
     * @return transaction
     */
    public PaymentTransaction getTransaction() throws CanceledPaymentException {
        PaymentTransaction transaction = new PaymentTransaction(id, contents, amounts,  payTime);
        switch (responseCode){
            case "00":
                transaction.setStatus("Payment success!");
                //TODO: Change invoice status.
                break;
            case "24":
                throw new CanceledPaymentException("Payment was canceled!");
        }
        return transaction;
    }
}
