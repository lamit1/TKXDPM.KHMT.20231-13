package views.screen.payment;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import entity.payment.PaymentTransaction;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import views.screen.BaseScreenHandler;

public class ResultScreenHandler extends BaseScreenHandler {
	@FXML
	private Label resultLabel;
	@FXML
	private Label messageLabel;
	//  Functional cohesion
	public ResultScreenHandler(Stage stage, String screenPath, PaymentTransaction transaction) throws IOException {
		super(stage, screenPath);
		resultLabel.setText(transaction.getStatus());
		messageLabel.setText(transaction.getTransactionContent());
	}

	@FXML// no coupling
	// Coincidental cohesion
	void confirmPayment(MouseEvent event) throws IOException {
		homeScreenHandler.show();
	}

}
