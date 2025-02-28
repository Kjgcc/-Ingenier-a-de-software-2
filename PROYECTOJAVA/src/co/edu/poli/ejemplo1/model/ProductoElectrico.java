package co.edu.poli.ejemplo1.model;

public class ProductoElectrico extends Producto {
    private int voltajeEntrada;

    public ProductoElectrico(String nombre, double precio, int voltajeEntrada) {
        super(nombre, precio, "Electrico");
        this.voltajeEntrada = voltajeEntrada;
    }

    public int getVoltajeEntrada() { return voltajeEntrada; }

    @Override
    public String toString() {
        return super.toString() + ", voltajeEntrada=" + voltajeEntrada + "V";
    }
}
