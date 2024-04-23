package AnalisisOrganizacionInformacion;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrdenacionBusqueda {

    public static void ordenarNombres(List<String> nombres) {
        Collections.sort(nombres);
    }

    public static void ordenarVentas(List<Venta> ventas, Comparator<Venta> comparator) {
        ventas.sort(comparator);
    }
}