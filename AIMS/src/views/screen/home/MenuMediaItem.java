package views.screen.home;

import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

import java.util.ArrayList;
import java.util.List;

public class MenuMediaItem {
    private static HBox hboxMedia;

    private static List homeItems;



    public static void addMediaHome(List items){
        ArrayList mediaItems = (ArrayList)((ArrayList) items).clone();
        hboxMedia.getChildren().forEach(node -> {
            if (!node.getClass().equals(ScrollBar.class)) {
                VBox vBox = (VBox) node;
                vBox.getChildren().clear();
            }
        });
        while(!mediaItems.isEmpty()){
            hboxMedia.getChildren().forEach(node -> {
                if (!node.getClass().equals(ScrollBar.class)) {
                    int vid = hboxMedia.getChildren().indexOf(node);
                    VBox vBox = (VBox) node;
                    while(vBox.getChildren().size()<3 && !mediaItems.isEmpty()){
                        MediaHandler media = (MediaHandler) mediaItems.get(0);
                        vBox.getChildren().add(media.getContent());
                        mediaItems.remove(media);
                    }
                }
            });
            return;
        }
    }
    //no coupling
    // functional cohesion
    public static void addMenuItem(int position, String text, MenuButton menuButton){
        MenuItem menuItem = new MenuItem();
        Label label = new Label();
        label.prefWidthProperty().bind(menuButton.widthProperty().subtract(31));
        label.setText(text);
        label.setTextAlignment(TextAlignment.RIGHT);
        menuItem.setGraphic(label);
        menuItem.setOnAction(e -> {
            hboxMedia.getChildren().forEach(node -> {
                VBox vBox = (VBox) node;
                vBox.getChildren().clear();
            });
            List filteredItems = new ArrayList<>();
            homeItems.forEach(me -> {
                MediaHandler media = (MediaHandler) me;
                if (media.getMedia().getTitle().toLowerCase().startsWith(text.toLowerCase())){
                    filteredItems.add(media);
                }
            });
            addMediaHome(filteredItems);
        });
        menuButton.getItems().add(position, menuItem);
    }






}
