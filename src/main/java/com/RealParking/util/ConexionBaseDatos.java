package com.RealParking.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {

    private static String url = "jdbc:mysql://localhost:3306/real_parking";
    //private static String url = "jdbc:mysql://localhost:3306/java_curso?serverTimezone=America/Lima";
    private static String username = "root";
    private static String password = "root";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}
