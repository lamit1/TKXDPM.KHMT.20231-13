package org.example.views.screens;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.controllers.CartController;
import org.example.exceptions.NoMediaInCartException;
import org.example.models.Media;
import org.example.utils.MessageBox;
import org.example.views.media_items.CartMediaItem;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

public class CartScreen implements Initializable {
    public Button orderButton;
    public VBox mediaContainer;
    public Button backHomeButton;
    public Label totalPriceLabel;
    private CartController cartController = new CartController();

    //data coupling
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<HashMap<Media, Integer>> mediaBuyList = cartController.getMediaBuyItems();
        List<HashMap<Media, Integer>> mediaList = cartController.getMediaItems();
        List<Pane> mediaPanes = new ArrayList<>();
        mediaList.forEach(media -> {
            try {
                FXMLLoader mediaLoader = new FXMLLoader(getClass().getResource("/fxml/cart_media.fxml"));
                Pane item = mediaLoader.load();
                CartMediaItem mediaItemController = mediaLoader.getController();
                mediaItemController.setInfo(media);
                mediaItemController.setItemContainer(mediaContainer);
                mediaItemController.setTotalPriceLabel(totalPriceLabel);
                mediaPanes.add(item);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        mediaContainer.getChildren().addAll(mediaPanes);
        totalPriceLabel.setText(cartController.getCartAmounts() + " đồng");
    }


    //no coupling
    @FXML
    public void backToHome(ActionEvent e) throws IOException {
        FXMLLoader deliveryLoader = new FXMLLoader(getClass().getResource("/fxml/home.fxml"));
        Stage stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        stage.setScene(new Scene(deliveryLoader.load()));
        cartController.clearListBuyMedia();
    }


    //no coupling
    @FXML
    public void placeOrder(ActionEvent e) throws IOException {
        if (totalPriceLabel.getText().equals("0.0 đồng")) {
            try {
                throw new NoMediaInCartException("Cart have no item!");
            } catch (NoMediaInCartException ex) {
                MessageBox.showAlert("Cart error","No media in cart, please check again",ex.getMessage(), Alert.AlertType.WARNING);
                return;
            }
        }
        FXMLLoader deliveryLoader = new FXMLLoader(getClass().getResource("/fxml/delivery.fxml"));
        Stage stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        stage.setScene(new Scene(deliveryLoader.load()));

    }


}
