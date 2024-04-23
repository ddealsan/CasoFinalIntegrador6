package MapasAsociacionDatos;

import java.util.HashMap;
import java.util.Map;

public class GestionMapas {
    private Map<Integer, String> mapa;

    public GestionMapas() {
        mapa = new HashMap<>();
    }

    public void agregarElemento(int clave, String valor) {
        mapa.put(clave, valor);
    }

    public String recuperarElemento(int clave) {
        return mapa.get(clave);
    }
}