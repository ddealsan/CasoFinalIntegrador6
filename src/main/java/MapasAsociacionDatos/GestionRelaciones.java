package MapasAsociacionDatos;

import java.util.HashMap;
import java.util.Map;

public class GestionRelaciones {

    private Map<Integer, String> relaciones = new HashMap<>();

    public void agregarRelacion(int numero, String texto) {
        relaciones.put(numero, texto);
    }

    public String obtenerTexto(int numero) {
        return relaciones.get(numero);
    }
}