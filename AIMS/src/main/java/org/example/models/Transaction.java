package org.example.models;

import org.example.utils.DBConnection;

import java.sql.*;

public class Transaction {
    private int id;
    private double amount;
    private String content;
    private Timestamp time;

    public void setContent(String content) {
        this.content = content;
    }

    public Transaction() {
    }


    public Transaction(int id, double amount, String content, Timestamp time) {
        this.id = id;
        this.amount = amount;
        this.content = content;
        this.time = time;
    }

    public Transaction(double amount, String content, Timestamp time) {
        this.amount = amount;
        this.time = time;
        this.content = content;
    }

    @Override
    public boolean equals(Object obj) {
        Transaction transaction = (Transaction) obj;
        return (this.content.equals(transaction.content)
                && this.amount == transaction.amount);
    }

    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public String getContent() {
        return content;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setAmount(double vnpAmount) {
        this.amount = vnpAmount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return this.amount + " " + this.content;
    }

    public static void saveTransaction(Transaction transaction) {
        try (Connection connection = new DBConnection().getConnection()) {
            String sql;
            if (transaction.getTransactionId() != 0) {
                sql = "INSERT INTO transaction (amount, contents, error_message, time, transaction_id) VALUES (?, ?, ?, ?, ?)";
            } else {
                sql = "INSERT INTO transaction (amount, contents, error_message, time) VALUES (?, ?, ?, ?)";
            }

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setFloat(1, (float) transaction.getAmount());
                preparedStatement.setString(2, transaction.getContent());
                preparedStatement.setString(3, "");
                preparedStatement.setTimestamp(4, transaction.getTime());

                if (transaction.getTransactionId() != 0) {
                    preparedStatement.setInt(5, transaction.getTransactionId());
                }

                preparedStatement.executeUpdate();

                // Retrieve the generated keys (if any)
                if (transaction.getTransactionId() == 0) {
                    try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                            transaction.setId(generatedKeys.getInt(1));
                        } else {
                            throw new SQLException("Creating transaction failed, no ID obtained.");
                        }
                    }
                }

            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your needs
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public int getTransactionId() {
        return id;
    }
}
