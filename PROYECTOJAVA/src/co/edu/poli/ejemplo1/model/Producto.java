package co.edu.poli.ejemplo1.model;

public abstract class Producto {
    protected int id;
    protected String nombre;
    protected double precio;
    protected String tipo;

    public Producto(String nombre, double precio, String tipo) {
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public String getTipo() { return tipo; }

    @Override
    public String toString() {
        return "Producto{id=" + id + ", nombre='" + nombre + "', precio=" + precio + ", tipo='" + tipo + "'}";
    }
}


