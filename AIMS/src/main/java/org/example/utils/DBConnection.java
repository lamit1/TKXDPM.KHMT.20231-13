package org.example.utils;


import java.sql.*;

public class DBConnection {
    private String url = "jdbc:mysql://localhost:3306/aims";
    private String username = "root";
    private String password = "";

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}
