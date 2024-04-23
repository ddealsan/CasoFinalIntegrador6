package AnalisisOrganizacionInformacion;

import java.util.List;
import java.util.stream.Collectors;

public class AnalisisRegistros {

    public static List<Venta> filtrarVentas(List<Venta> ventas, String producto) {
        return ventas.stream()
                .filter(venta -> venta.getProducto().equals(producto))
                .collect(Collectors.toList());
    }
}