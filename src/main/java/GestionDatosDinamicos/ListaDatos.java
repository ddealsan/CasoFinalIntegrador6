package GestionDatosDinamicos;

import java.util.ArrayList;
import java.util.List;

public class ListaDatos {
    private List<Object> datos;

    public ListaDatos() {
        this.datos = new ArrayList<>();
    }

    public void agregarDato(Object dato) {
        this.datos.add(dato);
    }

    public void eliminarDato(Object dato) {
        this.datos.remove(dato);
    }

    public List<Object> getDatos() {
        return datos;
    }
}