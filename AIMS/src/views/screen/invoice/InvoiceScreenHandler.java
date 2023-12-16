package views.screen.invoice;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Logger;

import common.exception.ProcessInvoiceException;
import controller.PaymentController;
import entity.cart.Cart;
import entity.invoice.Invoice;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utils.Configs;
import utils.Utils;
import views.screen.BaseScreenHandler;
import views.screen.payment.PaymentScreenHandler;

public class InvoiceScreenHandler extends BaseScreenHandler {

	private static Logger LOGGER = Utils.getLogger(InvoiceScreenHandler.class.getName());

	@FXML
	private Label pageTitle;

	@FXML
	private Label name;

	@FXML
	private Label phone;

	@FXML
	private Label province;

	@FXML
	private Label address;

	@FXML
	private Label instructions;

	@FXML
	private Label subtotal;

	@FXML
	private Label shippingFees;

	@FXML
	private Label total;

	@FXML
	private VBox vboxItems;

	private Invoice invoice;
	// data coupling
	// Coincidental cohesion
	public InvoiceScreenHandler(Stage stage, String screenPath, Invoice invoice) throws IOException {
		super(stage, screenPath);
		this.invoice = invoice;
		setInvoiceInfo();
	}
	//no coupling
	//Procedural cohesion
	private void setInvoiceInfo(){
		HashMap<String, String> deliveryInfo = invoice.getOrder().getDeliveryInfo();
		name.setText(deliveryInfo.get("name"));
		province.setText(deliveryInfo.get("province"));
		instructions.setText(deliveryInfo.get("instructions"));
		address.setText(deliveryInfo.get("address"));
		subtotal.setText(Utils.getCurrencyFormat(invoice.getOrder().getOrderAmount()));
		shippingFees.setText(Utils.getCurrencyFormat(invoice.getOrder().getShippingFees()));
		int amount = invoice.getOrder().getOrderAmount() + invoice.getOrder().getShippingFees();
		total.setText(Utils.getCurrencyFormat(amount));
		invoice.setAmount(amount);
		Cart.getCart().getListMedia().forEach(orderMedia -> {
			try {
				MediaInvoiceScreenHandler mis = new MediaInvoiceScreenHandler(Configs.INVOICE_MEDIA_SCREEN_PATH);
				mis.setOrderMedia(orderMedia);
				vboxItems.getChildren().add(mis.getContent());
			} catch (IOException | SQLException e) {
				System.err.println("errors: " + e.getMessage());
				throw new ProcessInvoiceException(e.getMessage());
			}

		});

	}
	//no coupling
	//Coincidental cohesion
	@FXML
	void confirmInvoice(MouseEvent event) throws IOException {
		BaseScreenHandler paymentScreen = new PaymentScreenHandler(this.stage, Configs.PAYMENT_SCREEN_PATH, invoice);
		paymentScreen.setBController(new PaymentController());
		paymentScreen.setPreviousScreen(this);
		paymentScreen.setHomeScreenHandler(homeScreenHandler);
		paymentScreen.setScreenTitle("Payment Screen");
		paymentScreen.show();
		LOGGER.info("Confirmed invoice");
	}

}
