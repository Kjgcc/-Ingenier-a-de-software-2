package co.edu.poli.ejemplo1.model;

public class Proveedor {
    private String nombre;
    private String evaluacion;
    private double calificacion;
    private String politicaEntrega;

    // Constructor privado para el patrón Builder
    private Proveedor(Builder builder) {
        this.nombre = builder.nombre;
        this.evaluacion = builder.evaluacion;
        this.calificacion = builder.calificacion;
        this.politicaEntrega = builder.politicaEntrega;
    }

    // Getters
    public String getNombre() { return nombre; }
    public String getEvaluacion() { return evaluacion; }
    public double getCalificacion() { return calificacion; }
    public String getPoliticaEntrega() { return politicaEntrega; }

    // Método toString mejorado con formato estructurado
    @Override
    public String toString() {
        return "-----------------------------------\n" +
               "        INFORMACIÓN DEL PROVEEDOR\n" +
               "-----------------------------------\n" +
               " Nombre:          " + nombre + "\n" +
               " Evaluación:      " + evaluacion + "\n" +
               " Calificación:    " + calificacion + " / 5.0\n" +
               " Política Entrega:" + politicaEntrega + "\n" +
               "-----------------------------------";
    }

    // Clase interna Builder
    public static class Builder {
        private String nombre;
        private String evaluacion;
        private double calificacion;
        private String politicaEntrega;

        public Builder setNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public Builder setEvaluacion(String evaluacion) {
            this.evaluacion = evaluacion;
            return this;
        }

        public Builder setCalificacion(double calificacion) {
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
}
