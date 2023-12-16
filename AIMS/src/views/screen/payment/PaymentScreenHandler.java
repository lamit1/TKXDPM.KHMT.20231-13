package views.screen.payment;

import java.io.IOException;
import java.util.Map;

import controller.PaymentController;
import entity.cart.Cart;
import common.exception.PlaceOrderException;
import entity.invoice.Invoice;
import entity.payment.PaymentTransaction;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import utils.Configs;
import views.screen.BaseScreenHandler;
import views.screen.popup.PopupScreen;

public class PaymentScreenHandler extends BaseScreenHandler {
	@FXML
	private Button btnConfirmPayment;
	@FXML
	private ImageView loadingImage;
	private Invoice invoice;
// no coupling
// Coincidental cohesion
	public PaymentScreenHandler(Stage stage, String screenPath, int amount, String contents) throws IOException {
		super(stage, screenPath);
	}
//data coupling
//Functional  cohetion
	public PaymentScreenHandler(Stage stage, String screenPath, Invoice invoice) throws IOException {
		super(stage, screenPath);
		this.invoice = invoice;
		btnConfirmPayment.setOnMouseClicked(e -> {
			try {
				confirmToPayOrder();
				((PaymentController) getBController()).emptyCart();
			} catch (Exception exp) {
				System.out.println(exp.getStackTrace());
			}
		});
	}
	// no coupling
	//Procedural cohesion
	void confirmToPayOrder() throws IOException{
		String contents = "Success";
		PaymentController ctrl = (PaymentController) getBController();
		PaymentTransaction transaction = ctrl.payOrder(invoice.getAmount(), contents);
		// Stamp coupling
		BaseScreenHandler resultScreen = new ResultScreenHandler(this.stage, Configs.RESULT_SCREEN_PATH, transaction);
		resultScreen.setPreviousScreen(this);
		resultScreen.setHomeScreenHandler(homeScreenHandler);
		resultScreen.setScreenTitle("Result Screen");
		resultScreen.show();
	}

}
