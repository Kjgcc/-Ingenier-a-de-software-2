package co.edu.poli.ejemplo1.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DatabaseConnection {
    private static Connection connection;
    
    public static Connection getConnection() {
        if (connection == null) {
            try {
                ResourceBundle rb = ResourceBundle.getBundle("database");
                String url = rb.getString("db.url");
                String user = rb.getString("db.user");
                String password = rb.getString("db.password");
                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                throw new RuntimeException("⚠️ No se pudo conectar a la base de datos.");
            }
        }
        return connection;
    }
}



