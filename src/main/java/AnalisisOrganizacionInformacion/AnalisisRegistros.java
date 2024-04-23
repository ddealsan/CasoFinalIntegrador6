package AnalisisOrganizacionInformacion;

import java.util.*;

public class AnalisisRegistros {
    private OrdenacionBusqueda ordenacionBusqueda;
    private List<Venta> ventas;

    public AnalisisRegistros(List<Venta> ventas) {
        this.ventas = ventas;
        this.ordenacionBusqueda = new OrdenacionBusqueda();
    }

    public void ordenarVentasPorProducto() {
        ventas = ordenacionBusqueda.ordenarPorProducto(ventas);
    }

    public void ordenarVentasPorCantidad() {
        ventas = ordenacionBusqueda.ordenarPorCantidad(ventas);
    }

    public Venta buscarVenta(String producto) {
        return ordenacionBusqueda.buscarVenta(ventas, producto);
    }

    // Método para obtener las ventas
    public List<Venta> getVentas() {
        return ventas;
    }
}