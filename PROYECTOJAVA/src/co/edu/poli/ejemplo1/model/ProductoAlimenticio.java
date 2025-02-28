package co.edu.poli.ejemplo1.model;

public class ProductoAlimenticio extends Producto {
    private int aporteCalorico;

    public ProductoAlimenticio(String nombre, double precio, int aporteCalorico) {
        super(nombre, precio, "Alimenticio");
        this.aporteCalorico = aporteCalorico;
    }

    public int getAporteCalorico() { return aporteCalorico; }

    @Override
    public String toString() {
        return super.toString() + ", aporteCalorico=" + aporteCalorico + " kcal";
    }
}
