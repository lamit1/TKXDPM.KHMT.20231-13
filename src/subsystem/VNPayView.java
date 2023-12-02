package subsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.concurrent.CompletableFuture;

public class VNPayView {
    @FXML
    private WebView vnpayWebView;
    public WebView getWebView() {
        return vnpayWebView;
    }

    public VNPayView() {}

    public String query(String url) {
        try {
            CompletableFuture<String> responseUrlFuture = new CompletableFuture<>();
            FXMLLoader newWindowLoader = new FXMLLoader(getClass().getResource("/views/fxml/vnpay_view.fxml"));
            Parent newWindowRoot = newWindowLoader.load();
            VNPayView vnPayView = newWindowLoader.getController();
            vnPayView.getWebView().getEngine().load(url);

            Stage newWindowStage = new Stage();
            newWindowStage.initModality(Modality.APPLICATION_MODAL);
            newWindowStage.setTitle("VNPay Payment");
            newWindowStage.setScene(new Scene(newWindowRoot));

            newWindowStage.setOnCloseRequest(event -> {
                /*
                  Content coupling
                 */
                String responseUrl = vnPayView.getWebView().getEngine().getLocation();
                responseUrlFuture.complete(responseUrl);
            });

            newWindowStage.showAndWait();
            return responseUrlFuture.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
