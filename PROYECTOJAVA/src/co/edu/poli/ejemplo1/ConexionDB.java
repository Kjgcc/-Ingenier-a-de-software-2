package co.edu.poli.ejemplo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConexionDB {
    private static Connection connection;
    private static String errorMessage; // Guarda el mensaje de error

    private ConexionDB() {}

    public static Connection getInstance() {
        if (connection == null) {
            try {
                ResourceBundle rb = ResourceBundle.getBundle("database");
                String url = rb.getString("db.url");
                String user = rb.getString("db.user");
                String password = rb.getString("db.password");
                connection = DriverManager.getConnection(url, user, password);
                errorMessage = null; // Limpia errores previos
            } catch (SQLException e) {
                errorMessage = "⚠️ Error al conectar con la base de datos: " + e.getMessage();
                connection = null; // Asegura que no haya una conexión inválida
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("🔌 Conexión cerrada.");
            } catch (SQLException e) {
                errorMessage = "⚠️ Error al cerrar la conexión: " + e.getMessage();
            }
        }
    }

    // Método para obtener el último mensaje de error
    public static String getErrorMessage() {
        return errorMessage;
    }
}


