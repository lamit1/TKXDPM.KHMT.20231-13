package org.example;

import com.google.gson.JsonObject;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.models.Transaction;
import org.example.subsystem.VNPaySubsystem.refund.RefundRequest;

public class App extends Application {

    public App() {
    }

    @Override
    public void start(Stage stage) throws Exception {
        //Start
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/home.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Home");
        stage.show();
    }

    public static void main() {
        launch();
    }

}