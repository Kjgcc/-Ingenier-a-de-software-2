package co.edu.poli.ejemplo1;

import co.edu.poli.ejemplo1.database.ProductoDAO;
import co.edu.poli.ejemplo1.model.Producto;
import co.edu.poli.ejemplo1.model.ProductoAlimenticio;
import co.edu.poli.ejemplo1.model.ProductoElectrico;

import java.sql.Connection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
    	Connection conn = ConexionDB.getInstance();
    	if (conn == null) {
    	    System.out.println(ConexionDB.getErrorMessage());
    	} else {
    	    System.out.println("🎉 Base de datos conectada.");
    	}

        // 2️⃣ Crear el DAO
        ProductoDAO productoDAO = new ProductoDAO();

        // 3️⃣ Crear productos
        Producto producto1 = new ProductoAlimenticio("Galletas", 5000, 250);
        Producto producto2 = new ProductoElectrico("Cargador", 30000, 110);

        // 4️⃣ Guardar productos
        productoDAO.guardarProducto(producto1);
        productoDAO.guardarProducto(producto2);

        // 5️⃣ Consultar productos
        List<Producto> productos = productoDAO.obtenerTodos();
        System.out.println("📦 Lista de productos:");
        for (Producto p : productos) {
            System.out.println(p);
        }

        // 6️⃣ Cerrar conexión
        ConexionDB.closeConnection();
    }
}



