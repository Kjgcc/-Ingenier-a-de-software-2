package co.edu.poli.ejemplo1.model;

public class Proveedor {
    private String proveedor;
    private String evaluacion;
    private int calificacion;
    private String politicaEntrega;

    // Constructor privado para el patrón Builder
    private Proveedor(Builder builder) {
        this.proveedor = builder.proveedor;
        this.evaluacion = builder.evaluacion;
        this.calificacion = builder.calificacion;
        this.politicaEntrega = builder.politicaEntrega;
    }

    // Clase interna estática Builder
    public static class Builder {
        private String proveedor;
        private String evaluacion;
        private int calificacion;
        private String politicaEntrega;

        public Builder setProveedor(String proveedor) {
            this.proveedor = proveedor;
            return this;
        }

        public Builder setEvaluacion(String evaluacion) {
            this.evaluacion = evaluacion;
            return this;
        }

        public Builder setCalificacion(int calificacion) {
            this.calificacion = calificacion;
            return this;
        }

        public Builder setPoliticaEntrega(String politicaEntrega) {
            this.politicaEntrega = politicaEntrega;
            return this;
        }

        public Proveedor build() {
            return new Proveedor(this);
        }
    }

    // Método para mostrar la información del producto
    @Override
    public String toString() {
        return "Producto{" +
                "proveedor='" + proveedor + '\'' +
                ", evaluación='" + evaluacion + '\'' +
                ", calificación=" + calificacion +
                ", política de entrega='" + politicaEntrega + '\'' +
                '}';
    }

    public static void main(String[] args) {
        // Creación de un objeto usando el patrón Builder
        Proveedor producto = new Proveedor.Builder()
                .setProveedor("Proveedor XYZ")
                .setEvaluacion("Producto de alta calidad")
                .setCalificacion(5)
                .setPoliticaEntrega("Entrega en 24 horas")
                .build();

        System.out.println(producto);
    }
}

// Porbeedor