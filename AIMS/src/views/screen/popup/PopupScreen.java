package views.screen.popup;

import java.io.IOException;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import utils.Configs;
import views.screen.BaseScreenHandler;


public class PopupScreen extends BaseScreenHandler{


    @FXML
    ImageView tickicon;

    @FXML
    Label message;

    // no coupling
// data coupling

    public PopupScreen(Stage stage) throws IOException{
        super(stage, Configs.POPUP_PATH);
    }
// no coupling
// Functional cohesion
    private static PopupScreen popup(String message, String imagepath, Boolean undecorated) throws IOException{
        PopupScreen popup = new PopupScreen(new Stage());
        if (undecorated) popup.stage.initStyle(StageStyle.UNDECORATED);
        popup.message.setText(message);
        popup.setImage(imagepath);
        return popup;
    }
// no coupling
//Coincidental cohesion
    public static void success(String message) throws IOException{
        popup(message, Configs.IMAGE_PATH + "/" + "tickgreen.png", true).show(true);
    }
// no coupling
//Coincidental cohesion

    public static void error(String message) throws IOException{
        popup(message, Configs.IMAGE_PATH + "/" + "tickerror.png", false).show(false);
    }
// no coupling
//Coincidental cohesion

    public static PopupScreen loading(String message) throws IOException{
        return popup(message, Configs.IMAGE_PATH + "/" + "loading.gif", true);
    }
// no coupling
//Coincidental cohesion

    public void setImage(String path) {
        super.setImage(tickicon, path);
    }
// no coupling
//Coincidental cohesion

    public void show(Boolean autoclose) {
        super.show();
        if (autoclose) close(0.8);
    }
// no coupling
//Coincidental cohesion

    public void show(double time) {
        super.show();
        close(time);
    }
// no coupling
//Coincidental cohesion

    public void close(double time){
        PauseTransition delay = new PauseTransition(Duration.seconds(time));
        delay.setOnFinished( event -> stage.close() );
        delay.play();
    }
}