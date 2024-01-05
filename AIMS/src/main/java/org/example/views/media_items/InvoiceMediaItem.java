package org.example.views.media_items;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import org.example.models.Media;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class InvoiceMediaItem {
    public ImageView imageView;
    public Label mediaQuantityLabel;
    public Label mediaLabel;
    public Label priceLabel;
    public Label availableLabel;
    public Label typeLabel;
    //data coupling
    // Coincidental
    public void setInfo(HashMap<Media, Integer> mediaMap) {
        for (Map.Entry<Media, Integer> entry : mediaMap.entrySet()) {
            Media media = entry.getKey();
            Integer quantity = entry.getValue();
            mediaQuantityLabel.setText(String.valueOf(quantity));
            mediaLabel.setText(media.getName());
            priceLabel.setText(media.getPrice()+ " đồng");
            availableLabel.setText(String.valueOf(media.getAvailable()));
            typeLabel.setText(media.getCategory());
        }
    }
}
