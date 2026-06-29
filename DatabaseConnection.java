/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package meditrack.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class DatabaseConnection {
     private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                String url = "jdbc:mysql://localhost:3306/meditrack_db";
                String user = "root";
                String password = "";

                connection = DriverManager.getConnection(url, user, password);
                System.out.println("Koneksi berhasil");
            } catch (SQLException e) {
                System.out.println("Koneksi gagal : " + e.getMessage());
            }
        }

        return connection;
    }
}
