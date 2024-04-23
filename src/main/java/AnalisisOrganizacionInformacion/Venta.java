package AnalisisOrganizacionInformacion;

public class Venta {
    private String producto;
    // Otros campos como cliente, cantidad, etc.

    public Venta(String producto) {
        this.producto = producto;
        // Inicializar otros campos
    }

    public String getProducto() {
        return producto;
    }

    // Otros getters y setters según sea necesario
}