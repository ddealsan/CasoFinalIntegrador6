package IndexacionVisualizacionArchivos;

import java.util.Map;
import java.util.TreeMap;

public class OrdenacionListado {

    private IndexacionRecursiva indexacionRecursiva;

    public OrdenacionListado(IndexacionRecursiva indexacionRecursiva) {
        this.indexacionRecursiva = indexacionRecursiva;
    }

    public void listarArchivosOrdenados() {
        Map<String, String> indexacionOrdenada = new TreeMap<>(indexacionRecursiva.getIndexacion());

        for (Map.Entry<String, String> entrada : indexacionOrdenada.entrySet()) {
            System.out.println("Nombre del archivo: " + entrada.getKey() + ", Ruta completa: " + entrada.getValue());
        }
    }
}