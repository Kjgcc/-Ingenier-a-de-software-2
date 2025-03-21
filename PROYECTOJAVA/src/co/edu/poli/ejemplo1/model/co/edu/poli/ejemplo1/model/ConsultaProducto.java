package co.edu.poli.ejemplo1.model;

import co.edu.poli.ejemplo1.database.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultaProducto {
    private Connection connection;

    public ConsultaProducto() {
        this.connection = DatabaseConnection.getConnection();
    }

    public void buscarPorTipo(String tipo) {
        String sql = "SELECT * FROM productos WHERE tipo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, tipo);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("nombre") + " - " + rs.getDouble("precio"));
            }
        } catch (SQLException e) {
            System.err.println("❌ Error en consulta: " + e.getMessage());
        }
    }
}
