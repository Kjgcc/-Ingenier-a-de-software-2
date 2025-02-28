package co.edu.poli.ejemplo1.database;

import co.edu.poli.ejemplo1.ConexionDB;
import co.edu.poli.ejemplo1.model.Producto;
import co.edu.poli.ejemplo1.model.ProductoAlimenticio;
import co.edu.poli.ejemplo1.model.ProductoElectrico;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    public void guardarProducto(Producto producto) {
        String sql = "INSERT INTO productos (nombre, precio, tipo, valor_extra) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexionDB.getInstance();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, producto.getNombre());
            stmt.setDouble(2, producto.getPrecio());
            stmt.setString(3, producto.getTipo());

            if (producto instanceof ProductoAlimenticio) {
                stmt.setInt(4, ((ProductoAlimenticio) producto).getAporteCalorico());
            } else if (producto instanceof ProductoElectrico) {
                stmt.setInt(4, ((ProductoElectrico) producto).getVoltajeEntrada());
            }

            stmt.executeUpdate();
            System.out.println("✅ Producto guardado: " + producto.getNombre());

        } catch (SQLException e) {
            System.out.println("⚠️ Error al guardar el producto: " + e.getMessage());
        }
    }

    public List<Producto> obtenerTodos() {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT id, nombre, precio, tipo, valor_extra FROM productos";

        try (Connection conn = ConexionDB.getInstance();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                double precio = rs.getDouble("precio");
                String tipo = rs.getString("tipo");
                int valorExtra = rs.getInt("valor_extra");

                Producto producto;
                if ("Alimenticio".equals(tipo)) {
                    producto = new ProductoAlimenticio(nombre, precio, valorExtra);
                } else {
                    producto = new ProductoElectrico(nombre, precio, valorExtra);
                }
                producto.setId(id);
                productos.add(producto);
            }

        } catch (SQLException e) {
            System.out.println("⚠️ Error al obtener los productos: " + e.getMessage());
        }

        return productos;
    }
}
