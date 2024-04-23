package AnalisisOrganizacionInformacion;

import java.util.*;

public class OrdenacionBusqueda {
    public List<Venta> ordenarPorProducto(List<Venta> ventas) {
        ventas.sort(Comparator.comparing(Venta::getProducto));
        return ventas;
    }

    public List<Venta> ordenarPorCantidad(List<Venta> ventas) {
        ventas.sort(Comparator.comparing(Venta::getCantidad));
        return ventas;
    }

    public Venta buscarVenta(List<Venta> ventas, String producto) {
        for (Venta venta : ventas) {
            if (venta.getProducto().equals(producto)) {
                return venta;
            }
        }
        return null;
    }
}