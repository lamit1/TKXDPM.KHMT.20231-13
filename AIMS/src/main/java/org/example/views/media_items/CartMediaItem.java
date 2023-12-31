package org.example.views.media_items;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import org.example.controllers.CartController;
import org.example.exceptions.NotEnoughQuantityException;
import org.example.models.Media;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class CartMediaItem implements Initializable {
    private final CartController cartController = new CartController();
    private Media media;
    public Button decrementButton;
    public Button incrementButton;
    public ImageView imageView;
    public Label mediaQuantityLabel;
    public Button removeMediaButton;
    public Label mediaLabel;
    public Label priceLabel;
    public Label availableLabel;
    public Label typeLabel;
    private VBox parentVBox;
    private Label totalPriceLabel;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        incrementButton.setOnAction(e-> {
            mediaQuantityLabel.textProperty().set(String.valueOf(Integer.parseInt(mediaQuantityLabel.getText()) + 1));
            try {
                cartController.increaseMedia(media);
                totalPriceLabel.setText(String.valueOf(cartController.getCartAmounts())+" đồng");
            } catch (NotEnoughQuantityException ex) {
                throw new RuntimeException(ex);
            }
        });
        decrementButton.setOnAction(e-> {
            if (Integer.parseInt(mediaQuantityLabel.getText()) > 0) {
                mediaQuantityLabel.textProperty().set(String.valueOf(Integer.parseInt(mediaQuantityLabel.getText()) - 1));
                cartController.decreaseMedia(media);
                totalPriceLabel.setText(String.valueOf(cartController.getCartAmounts())+" đồng");
            } else {
                System.err.println("Cannot decrease item with 1 quantity");
            }
        });
        removeMediaButton.setOnAction(e -> {
            if (parentVBox != null) {
                parentVBox.getChildren().remove(this.imageView.getParent());
            }
            cartController.removeMedia(media);
            totalPriceLabel.setText(cartController.getCartAmounts() + " đồng");
        });
    }

    public void setInfo(HashMap<Media, Integer> media) {
        Media mediaItem = media.keySet().iterator().next();
        int quantity = media.get(mediaItem);
        this.media = mediaItem;
        mediaLabel.setText(mediaItem.getName());
        priceLabel.setText(String.valueOf(mediaItem.getPrice()));
        availableLabel.setText(String.valueOf(mediaItem.getAvailable()));
        typeLabel.setText(mediaItem.getCategory());
        mediaQuantityLabel.setText(String.valueOf(quantity));
        decrementButton.setDisable(quantity <= 1);
    }

    public void setItemContainer(VBox parentVBox) {
        this.parentVBox = parentVBox;
    }

    public void setTotalPriceLabel(Label totalPriceLabel) {
        this.totalPriceLabel = totalPriceLabel;
    }
}
