package co.edu.poli.ejemplo1.test;

import co.edu.poli.ejemplo1.model.Proveedor;

public class Main {
    public static void main(String[] args) {
        Proveedor proveedor = new Proveedor.Builder()
                .setNombre("Santiago Lopez Cative")
                .setEvaluacion("Alta calidad y puntualidad")
                .setCalificacion(4.8)
                .setPoliticaEntrega("Entrega en 48 horas sin costo adicional")
                .build();

        System.out.println(proveedor);
    }
}
