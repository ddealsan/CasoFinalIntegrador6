// En ListaDatos.java
package GestionDatosDinamicos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ListaDatos {
    private List<Pareja> datos;

    public ListaDatos() {
        this.datos = new ArrayList<>();
    }

    public void agregarDato(Pareja dato) {
        this.datos.add(dato);
    }

    public void eliminarDato(Pareja dato) {
        this.datos.removeIf(pareja -> pareja.getPrimero() == dato.getPrimero() && pareja.getSegundo() == dato.getSegundo());
    }

    public void modificarDato(Pareja datoAntiguo, Pareja datoNuevo) {
        int index = datos.indexOf(datoAntiguo);
        if (index != -1) {
            datos.set(index, datoNuevo);
        }
    }

    public List<Pareja> getDatos() {
        return datos;
    }

    public List<Pareja> filtrarPorPrimero(int valor) {
        return datos.stream()
                .filter(pareja -> pareja.getPrimero() == valor)
                .collect(Collectors.toList());
    }

    public List<Pareja> filtrarPorSegundo(int valor) {
        return datos.stream()
                .filter(pareja -> pareja.getSegundo() == valor)
                .collect(Collectors.toList());
    }

    public void ordenarPorPrimero() {
        datos.sort(Comparator.comparing(Pareja::getPrimero));
    }
}