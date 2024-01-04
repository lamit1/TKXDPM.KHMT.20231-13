package org.example.views.screens;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
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

    public AnchorPane mediaAnchorPane;

    public TextField searchField;
    public ChoiceBox searchType;

    final ScrollPane sp = new ScrollPane();


    public HomeScreen() {
        this.homeController = new HomeController();
    }
    // data coupling
    //Functional cohesion
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        searchType.getItems().addAll("NAME", "CATEGORY","PRICE");
        searchType.setValue("NAME");

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
        sp.setContent(mediaContainer);
        mediaContainer.getChildren().addAll(mediaPanes);
        mediaAnchorPane.getChildren().addAll(sp);
    }


    // data coupling
    //    Coincidental
    @FXML
    public void searchMedia(ActionEvent ae) {
        List<Media> mediaList = homeController.searchMediaList(searchType.getValue().toString(), searchField.getText());
        if (mediaList.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);

            alert.setHeaderText("Invalid media!!! ");
            alert.setContentText("Please try again :)");
            alert.showAndWait();


            List<Media> mediaList1 = homeController.getMediaItems();
            List<Pane> mediaPanes1 = new ArrayList<>();
            mediaList1.forEach(media -> {
                try {
                    FXMLLoader mediaLoader = new FXMLLoader(getClass().getResource("/fxml/home_media.fxml"));
                    Pane item = mediaLoader.load();
                    HomeMediaItem mediaItemController = mediaLoader.getController();
                    mediaItemController.setInfo(media);
                    mediaPanes1.add(item);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            mediaContainer.getChildren().clear();
            mediaContainer.getChildren().addAll(mediaPanes1);
            sp.setContent(mediaContainer);
        } else {
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
            mediaContainer.getChildren().clear();
            mediaContainer.getChildren().addAll(mediaPanes);
            sp.setContent(mediaContainer);
        }
    }

    //no coupling
    // no cohesion
    @FXML
    public void viewCart(ActionEvent e) throws IOException {
        FXMLLoader cartLoader = new FXMLLoader(getClass().getResource("/fxml/cart.fxml"));
        Stage stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        stage.setScene(new Scene(cartLoader.load()));
    }

}
