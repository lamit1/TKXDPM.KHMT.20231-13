package org.example.subsystem.VNPaySubsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
<<<<<<<< HEAD:AIMS/src/main/java/org/example/subsystem/VNPaySubsystem/VNPayView.java
import javafx.scene.control.Button;
========
import javafx.scene.layout.AnchorPane;
>>>>>>>> origin/release:AIMS/src/subsystem/VNPayView.java
import javafx.scene.web.WebView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import java.util.concurrent.CompletableFuture;

public class VNPayView {
    /**
     * This class have only 1 responsibility for view the VNPay Screen
     */
    @FXML
    private WebView vnpayWebView;
<<<<<<<< HEAD:AIMS/src/main/java/org/example/subsystem/VNPaySubsystem/VNPayView.java

    @FXML
    public void handleBackButton(ActionEvent e) {
        Stage stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        stage.fireEvent(new WindowEvent(stage,WindowEvent.WINDOW_CLOSE_REQUEST));
    }

    public WebView getWebView() {
        return vnpayWebView;
    }
    public VNPayView() {
        this.vnpayWebView = new WebView();
    }

    public String query(String url) {
        try {
            CompletableFuture<String> responseUrlFuture = new CompletableFuture<>();

            FXMLLoader newWindowLoader = new FXMLLoader(getClass().getResource("/fxml/vnpay_payment.fxml"));
========
    public WebView getWebView() {
        return vnpayWebView;
    }
    // Functional cohesion with 2 function, because need the instance to work
    public VNPayView() {}
    // Functional cohesion with getWebView to serve 1 purpose query for url
    public String query(String url) {
        try {
            CompletableFuture<String> responseUrlFuture = new CompletableFuture<>();
            FXMLLoader newWindowLoader = new FXMLLoader(getClass().getResource("/views/fxml/vnpay_view.fxml"));
>>>>>>>> origin/release:AIMS/src/subsystem/VNPayView.java
            Parent newWindowRoot = newWindowLoader.load();
            VNPayView vnPayView = newWindowLoader.getController();
            // Functional cohesion
            vnPayView.getWebView().getEngine().load(url);


            Stage newWindowStage = new Stage();
            newWindowStage.initModality(Modality.APPLICATION_MODAL);
            newWindowStage.setTitle("VNPay Payment");
            newWindowStage.setScene(new Scene(newWindowRoot));

            newWindowStage.setOnCloseRequest(event -> {
<<<<<<<< HEAD:AIMS/src/main/java/org/example/subsystem/VNPaySubsystem/VNPayView.java
                // Functional cohesion
========
                /*
                  Content coupling
                 */
>>>>>>>> origin/release:AIMS/src/subsystem/VNPayView.java
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
