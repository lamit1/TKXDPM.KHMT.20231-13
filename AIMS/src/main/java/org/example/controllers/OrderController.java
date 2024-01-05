package org.example.controllers;

import com.mysql.cj.protocol.Message;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import org.example.utils.DBConnection;
import org.example.utils.MessageBox;
import org.example.views.media_items.OrderItem;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OrderController {
    public boolean validatePhoneNumber(String phoneNumber) {
        if (phoneNumber == null) {
            return false;
        }
        String PHONE_NUMBER_PATTERN = "^(08|09)\\d{7,9}$";
        Pattern pattern = Pattern.compile(PHONE_NUMBER_PATTERN);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

    public List<Parent> getSearchItems(String phoneNumber) throws ClassNotFoundException {
        List<Parent> uiItems = new ArrayList<>();
        if(!validatePhoneNumber(phoneNumber)) {
            MessageBox.showAlert("Error in phone number","Phone Number is incorrect format","Wrong format", Alert.AlertType.WARNING);
            return uiItems;
        }
        String sql = "SELECT " +
                "    o.order_id, " +
                "    o.total_amounts, " +
                "    inv.transaction_id AS transaction_id, " +
                "    inv.status AS invoice_status, " +
                "    di.name AS receiver_name, " +
                "    di.phone_number, " +
                "    di.email, " +
                "    di.province, " +
                "    di.address " +
                "FROM `order` o " +
                "JOIN invoice inv ON o.order_id = inv.order_id " +
                "JOIN delivery_info di ON o.delivery_info_id = di.delivery_info_id " +
                "WHERE di.phone_number = ?;";

        try (Connection connection = new DBConnection().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, phoneNumber);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/fxml/order_item.fxml"));
                Parent root = loader.load();

                OrderItem controller = loader.getController(); // Get the controller instance

                // Call the setInfo method to update the UI components
                controller.setInfo(
                        resultSet.getString("order_id"),
                        resultSet.getString("transaction_id"),
                        resultSet.getString("total_amounts"),
                        resultSet.getString("invoice_status"),
                        resultSet.getString("receiver_name"),
                        resultSet.getString("phone_number"),
                        resultSet.getString("email"),
                        resultSet.getString("province"),
                        resultSet.getString("address")
                );

                uiItems.add(root); // Add the root node to the list
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error accessing database or loading FXML", e);
        }
        if (uiItems.isEmpty()) {
            MessageBox.showAlert("No order found", "Check phone number if it is correct", "No order found", Alert.AlertType.INFORMATION);
        }
        return uiItems;
    }




}
