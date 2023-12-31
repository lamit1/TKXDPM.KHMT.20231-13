package org.example.models;

import org.example.exceptions.AddressNotSupportRushDeliveryException;
import org.example.exceptions.NoRushMediaException;
import org.example.utils.DBConnection;

import java.sql.*;
import java.util.HashMap;
import java.util.List;

public class Invoice {
    private int id;
    private Order order;
    private String status;
    private Transaction transaction;
    public Invoice(Order order) {
        this.order = order;
    }

    public Invoice(int id, Order order, String status, Transaction transaction) {
        this.id = id;
        this.order = order;
        this.status = status;
        this.transaction = transaction;
    }

    public static Invoice saveInvoice(Order order) throws SQLException, ClassNotFoundException {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null");
        }

        Invoice invoice = null;
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = new DBConnection().getConnection();
            String sql = "INSERT INTO invoice (order_id, amount, status) VALUES (?, ?, ?)";

            statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setInt(1, order.getId()); // Assuming getOrderId() returns the order ID
            statement.setDouble(2, order.getTotalAmounts()); // Assuming getTotalAmounts() returns the total amount
            statement.setString(3, "pending");

            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating invoice failed, no rows affected.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    invoice = new Invoice(generatedKeys.getInt(1), order, "pending", null);
                } else {
                    throw new SQLException("Creating invoice failed, no ID obtained.");
                }
            }
        } catch (SQLException | ClassNotFoundException | AddressNotSupportRushDeliveryException | NoRushMediaException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

        return invoice;
    }

    public int getId() {
        return 1;
    }

    public double getTotalAmounts() throws AddressNotSupportRushDeliveryException, NoRushMediaException {
        return order.getTotalAmounts();
    }

    public List<HashMap<Media, Integer>> getMediaItems() {
        return order.getMediaItems();
    }

    public void updateStatus(Transaction transaction) {
        Connection connection = null;
        String dropForeignKeyQuery = "ALTER TABLE `invoice` DROP FOREIGN KEY `invoice_ibfk_1`";
        String updateInvoiceQuery = "UPDATE invoice SET status = ?, transaction_id = ? WHERE invoice_id = ?";
        String addForeignKeyQuery = "ALTER TABLE `invoice` ADD CONSTRAINT `invoice_ibfk_1` FOREIGN KEY (`transaction_id`) REFERENCES `transaction` (`transaction_id`) ON UPDATE CASCADE";
        try {
            connection = new DBConnection().getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate(dropForeignKeyQuery);
            String status;
            if (transaction.getAmount() == -1) {
                status = "canceled";
            } else {
                status = "complete";
            }
            // Update the invoice
            try (PreparedStatement preparedStatement = connection.prepareStatement(updateInvoiceQuery)) {
                preparedStatement.setString(1, status);
                preparedStatement.setInt(2, transaction.getTransactionId());
                preparedStatement.setInt(3, id);
                preparedStatement.executeUpdate();
            }

            statement.executeUpdate(addForeignKeyQuery);

            System.out.println("Invoice status and transaction_id updated for invoice_id: " + id);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void clearCart() {
        order.clearCart();
    }
}