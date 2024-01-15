package views.screen;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

import controller.BaseController;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import views.screen.home.HomeScreenHandler;

public class BaseScreenHandler extends FXMLScreenHandler {

	private Scene scene;
	private BaseScreenHandler prev;
	protected final Stage stage;
	protected HomeScreenHandler homeScreenHandler;
	protected Hashtable<String, String> messages;
	private BaseController bController;
// no coupling
// Functional cohesion
	private BaseScreenHandler(String screenPath) throws IOException {
		super(screenPath);
		this.stage = new Stage();
	}
// data coupling
// Coincidental cohesion
	public void setPreviousScreen(BaseScreenHandler prev) {
		this.prev = prev;
	}
// no coupling
// Coincidental cohesion

	public BaseScreenHandler getPreviousScreen() {
		return this.prev;
	}
// no coupling
// 
	public BaseScreenHandler(Stage stage, String screenPath) throws IOException {
		super(screenPath);
		this.stage = stage;
	}
// no coupling
// // Coincidental cohesion

	public void show() {
		if (this.scene == null) {
			this.scene = new Scene(this.content);
		}
		this.stage.setScene(this.scene);
		this.stage.show();
	}
// no coupling
// // Coincidental cohesion

	public void setScreenTitle(String string) {
		this.stage.setTitle(string);
	}
// data coupling
 // Coincidental cohesion

	public void setBController(BaseController bController){
		this.bController = bController;
	}
// no coupling
// // Coincidental cohesion

	public BaseController getBController(){
		return this.bController;
	}
// no coupling
// Coincidental cohesion

	public void forward(Hashtable messages) {
		this.messages = messages;
	}
// data coupling
// Coincidental cohesion

	public void setHomeScreenHandler(HomeScreenHandler HomeScreenHandler) {
		this.homeScreenHandler = HomeScreenHandler;
	}

}
