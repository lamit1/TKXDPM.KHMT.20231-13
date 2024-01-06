package org.example.controllers;


import org.example.exceptions.InvalidQuantityException;
import org.example.exceptions.NotEnoughQuantityException;
import org.example.models.Book;
import org.example.models.Cart;
import org.example.models.Media;
import org.example.utils.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import static java.sql.DriverManager.getConnection;

public class HomeController {


    //Lấy danh sách sản phẩm
    //Data Coupling
    public List<Media> getMediaItems() {
        List<Media> mediaItems = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = new DBConnection().getConnection();
            statement = connection.createStatement();
            String query = "SELECT * FROM media";
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int mediaId = resultSet.getInt("media_id");
                double price = resultSet.getDouble("price");
                int available = resultSet.getInt("available");
                String name = resultSet.getString("name");
                String imageURL = resultSet.getString("imageURL");
                String category = resultSet.getString("category");
                double weight = resultSet.getDouble("weight");
                boolean supportRushDelivery = resultSet.getBoolean("support_rush_delivery");
                Media media = new Media(mediaId, name, price, supportRushDelivery, weight, available , imageURL, category);
                mediaItems.add(media);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(); // Handle the exception according to your needs
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return mediaItems;
    }

    //Data Coupling
    public List<Media> searchMediaList(String type, String info) {
        List<Media> mediaItems = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = new DBConnection().getConnection();
            statement = connection.createStatement();
            String query = "";
            switch (type) {
                case "NAME": {
                    query ="SELECT * FROM media WHERE name LIKE '%"+ info + "%'";
                    break;
                }
                case "CATEGORY": {
                    query =  "SELECT * FROM media WHERE category = "+ "'" +info + "'";
                    break;
                }
                case "PRICE": {
                    query =  String.format("SELECT * FROM media WHERE price <= %s", info);
                    break;
                }
                default: break;
            }
            System.out.println(query);
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int mediaId = resultSet.getInt("media_id");
                double price = resultSet.getDouble("price");
                int available = resultSet.getInt("available");
                String name = resultSet.getString("name");
                String imageURL = resultSet.getString("imageURL");
                String category = resultSet.getString("category");
                double weight = resultSet.getDouble("weight");
                boolean supportRushDelivery = resultSet.getBoolean("support_rush_delivery");
                Media media = new Media(mediaId, name, price, supportRushDelivery, weight, available , imageURL, category);
                mediaItems.add(media);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(); // Handle the exception according to your needs
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return mediaItems;
    }

}
