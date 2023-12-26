package org.example.views.media_items;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import org.example.controllers.RushDeliveryController;
import org.example.models.Media;

import java.util.HashMap;

public class RushDeliveryMediaItem {
    private RushDeliveryController controller;
    private Media media;
    public ImageView imageView;
    public Label mediaQuantityLabel;
    public Button removeMediaButton;
    public Label priceLabel;
    public Label mediaLabel;
    public Label deliveryTypeLabel;
    private VBox mediaContainer;


    public void removeMedia() {
        controller.removeMedia(media);
        if (mediaContainer != null) {
            mediaContainer.getChildren().remove(this.imageView.getParent());
        }
    }

    public void setItemContainer(VBox mediaContainer) {
        this.mediaContainer = mediaContainer;
    }

    public void setInfo(HashMap<Media, Integer> media) {
        Media mediaItem = media.keySet().iterator().next();
        int quantity = media.get(mediaItem);
        this.media = mediaItem;
        mediaLabel.setText(mediaItem.getName());
        priceLabel.setText(String.valueOf(mediaItem.getPrice()));
        deliveryTypeLabel.setText(mediaItem.isRushDelivery() ? "Giao hàng nhanh" : "Giao hàng thường");
        mediaQuantityLabel.setText(String.valueOf(quantity));
    }

    public void setController(RushDeliveryController controller) {
        this.controller = controller;
    }
}
