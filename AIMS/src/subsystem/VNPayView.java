package subsystem;

import config.Config;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


/* Sử dụng đúng nguyên lý Single Responsibility bởi vì
lớp VNPayView chỉ có duy nhất một nhiệm vụ là query đến url của vnpay_pay
Sai về nguyên lý Open Close vì như này sẽ không dễ dàng để mở rộng nếu có thay đổi
 */
public class VNPayView {
    @FXML
    private WebView vnpayWebView;
    public WebView getWebView() {
        return vnpayWebView;
    }
    // Functional cohesion with getWebView to serve 1 purpose query for url
    public String query(String url) throws IOException, ExecutionException, InterruptedException {
        CompletableFuture<String> responseUrlFuture = new CompletableFuture<>();
        FXMLLoader newWindowLoader = new FXMLLoader(getClass().getResource("/views/fxml/vnpay_view.fxml"));
        Parent newWindowRoot = newWindowLoader.load();
        VNPayView vnPayView = newWindowLoader.getController();
        WebView webView = vnPayView.getWebView();
        WebEngine webEngine = webView.getEngine();
        webEngine.load(url);

        Stage newWindowStage = new Stage();
        newWindowStage.initModality(Modality.APPLICATION_MODAL);
        newWindowStage.setTitle("VNPay Payment");
        newWindowStage.setScene(new Scene(newWindowRoot));

        webEngine.locationProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null && newValue.startsWith(Config.vnp_ReturnUrl)) {
                newWindowStage.close();
                responseUrlFuture.complete(newValue);
            }
        });

        newWindowStage.setOnCloseRequest(event -> {
        /*
          Content coupling
         */
            String responseUrl = webEngine.getLocation();
            responseUrlFuture.complete(responseUrl);
        });

        newWindowStage.showAndWait();
        return responseUrlFuture.get();
    }

}
