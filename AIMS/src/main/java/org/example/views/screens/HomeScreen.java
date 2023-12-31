package org.example.views.screens;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.controllers.HomeController;
import org.example.models.Media;
import org.example.views.media_items.HomeMediaItem;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class HomeScreen implements Initializable {
    public Button redirectPayBtn;
    private final HomeController homeController;
    public VBox mediaContainer;

    public HomeScreen() {
        this.homeController = new HomeController();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Media> mediaList = homeController.getMediaItems();
        List<Pane> mediaPanes = new ArrayList<>();
        mediaList.forEach(media -> {
            try {
                FXMLLoader mediaLoader = new FXMLLoader(getClass().getResource("/fxml/home_media.fxml"));
                Pane item = mediaLoader.load();
                HomeMediaItem mediaItemController = mediaLoader.getController();
                mediaItemController.setInfo(media);
                mediaPanes.add(item);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        mediaContainer.getChildren().addAll(mediaPanes);
    }


    @FXML
    public void viewCart(ActionEvent e) throws IOException {
        FXMLLoader cartLoader = new FXMLLoader(getClass().getResource("/fxml/cart.fxml"));
        Stage stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        stage.setScene(new Scene(cartLoader.load()));
    }

}
