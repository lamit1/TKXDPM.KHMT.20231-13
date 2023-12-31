package org.example.views.screens;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.example.exceptions.NoRushMediaException;
import org.example.models.*;
import org.example.utils.Config;
import org.example.controllers.DeliveryController;
import org.example.exceptions.AddressNotSupportRushDeliveryException;
import org.example.exceptions.InvalidInputException;
import org.example.exceptions.NoMediaInCartException;
import org.example.utils.MessageBox;

import java.io.IOException;
import java.sql.SQLException;

public class DeliveryScreen {
    public TextField rushTimeField;
    public TextField rushAddressField;
    public Label errorLabel;
    private DeliveryController deliveryController = new DeliveryController();
    public TextField nameTF;
    public TextField phoneTF;
    public ChoiceBox provinceChoiceBox;
    public Label addressTF;
    public Label emailTF;
    public Button cancelButton;
    public TextArea instructionTA;
    public Button submitButton;
    public CheckBox rushCheckBox;
    public Label shipAmountsLabel;
    public Label cartAmountsLabel;
    public Label totalAmountsLabel;

    @FXML
    private void initialize() {
        rushAddressField.setDisable(true);
        rushTimeField.setDisable(true);
        errorLabel.setText("");
        //Implement rushcheckbox action listener
        rushCheckBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue) {
                    try {
                        if (!deliveryController.checkRushDeliverySupport()) {
                            errorLabel.setText("No media support rush delivery!");
                            rushAddressField.setDisable(true);
                            rushTimeField.setDisable(true);
                            submitButton.setDisable(true);
                            return;
                        }
                        rushAddressField.setDisable(false);
                        rushTimeField.setDisable(false);
                        RushDelivery newDelivery = (RushDelivery) getDeliveryFromForm();
                        deliveryController.setDelivery(newDelivery);
                        openRushDeliveryForm();
                    } catch (IOException | AddressNotSupportRushDeliveryException | NoMediaInCartException |
                             NoRushMediaException e) {
                        errorLabel.setText("Address not suppport rush delivery");
                        System.err.println(e);
                    }
                } else {
                    rushAddressField.setDisable(true);
                    rushTimeField.setDisable(true);
                    submitButton.setDisable(false);
                }
            }
        });

        ObservableList<String> provinces = FXCollections.observableArrayList(Config.provinces);
        provinceChoiceBox.setValue("Hà Nội");
        provinceChoiceBox.setItems(provinces);
        // init cart amount
        cartAmountsLabel.setText(deliveryController.getCartAmounts() + " đồng");
        //implement when choose provinceChoicebox
        provinceChoiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue)->{
            if (oldValue == newValue) return;
            Delivery newDelivery = getDeliveryFromForm();
            deliveryController.setDelivery(newDelivery);
            if (newValue.equals("Hà Nội")) {
                try {
                    shipAmountsLabel.setText( deliveryController.getShipAmounts() + " đồng");
                    totalAmountsLabel.setText(deliveryController.getTotalAmounts() + " đồng");
                } catch (AddressNotSupportRushDeliveryException | NoMediaInCartException | NoRushMediaException e) {
                    throw new RuntimeException(e);
                }
            } else {
                rushCheckBox.setSelected(false);
            }
        });
        Delivery delivery = getDeliveryFromForm();
        this.deliveryController.setDelivery(delivery);
        //set total amount
        try {
            shipAmountsLabel.setText( deliveryController.getShipAmounts() + " đồng");
            totalAmountsLabel.setText(deliveryController.getTotalAmounts() + " đồng");
        } catch (AddressNotSupportRushDeliveryException | NoMediaInCartException | NoRushMediaException e) {
            throw new RuntimeException(e);
        }
    }

    private void openRushDeliveryForm() throws IOException, AddressNotSupportRushDeliveryException, NoMediaInCartException, NoRushMediaException {
        Stage newWindow = new Stage();
        newWindow.setTitle("Second Stage");
        FXMLLoader rushLoader = new FXMLLoader(getClass().getResource("/fxml/rush_delivery.fxml"));
        Scene secondScene = new Scene(rushLoader.load(), 900, 600);
        RushDeliveryScreen screen = rushLoader.getController();
        newWindow.setScene(secondScene);
        deliveryController.setDelivery(getDeliveryFromForm());
        screen.setOrder(deliveryController.getOrder());
        screen.initData();
        newWindow.showAndWait();
        cartAmountsLabel.setText(deliveryController.getCartAmounts() + " đồng");
        shipAmountsLabel.setText( deliveryController.getShipAmounts() + " đồng");
        totalAmountsLabel.setText(deliveryController.getTotalAmounts()+ " đồng");
    }


    private Delivery getDeliveryFromForm() {
        String receiverName = nameTF.getText();
        String email = emailTF.getText();
        String address = addressTF.getText();
        String phoneNumber = phoneTF.getText();
        String province = (String) provinceChoiceBox.getValue();
        String instruction = instructionTA.getText();
        String rushTime = rushTimeField.getText();
        String rushAddress = rushAddressField.getText();
        if (rushCheckBox.isSelected()) {
            return new RushDelivery(receiverName,phoneNumber,province,instruction,address,email, rushTime, rushAddress);
        } else
            return new Delivery(receiverName, phoneNumber, email, province, address, instruction);
    }


    public void submitForm(ActionEvent e) throws IOException, SQLException, ClassNotFoundException {
        Delivery d = getDeliveryFromForm();
        try {
            if (!deliveryController.validateForm(d) ) {
                throw new InvalidInputException("Wrong input format!");
            } else if (deliveryController.checkCartEmpty()) {
                throw new NoMediaInCartException("Cart is empty!");
            }
            deliveryController.saveDelivery(d);
        } catch (SQLException | ClassNotFoundException | InvalidInputException | NoMediaInCartException ex) {
            //if ex is input error exception then show alert
            if (ex instanceof  InvalidInputException || ex instanceof NoMediaInCartException) {
                MessageBox.showAlert("Input error", "There is some error on your cart or delivery, please check it again!", ex.getMessage(), Alert.AlertType.WARNING);
                return;
            }
            throw new RuntimeException(ex);
        }
        //Save order
        Order order = deliveryController.saveOrder(d);
        Invoice invoice = deliveryController.saveInvoice(order);
        //Load invoice screen
        FXMLLoader invoiceLoader = new FXMLLoader(getClass().getResource("/fxml/invoice.fxml"));
        Stage stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        Pane invoicePane = invoiceLoader.load(); // Load the FXML

        InvoiceScreen invoiceController = invoiceLoader.getController();
        invoiceController.setInvoice(invoice);
        invoiceController.initData();
        stage.setScene(new Scene(invoicePane));
    }




    public void backToCart(ActionEvent e) throws IOException {
        FXMLLoader cartLoader = new FXMLLoader(getClass().getResource("/fxml/cart.fxml"));
        Stage stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        stage.setScene(new Scene(cartLoader.load()));
    }
}
