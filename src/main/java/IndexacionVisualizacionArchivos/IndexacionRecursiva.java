package IndexacionVisualizacionArchivos;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class IndexacionRecursiva {

    private Map<String, String> indexacion = new HashMap<>();

    public void indexarDirectorio(File directorio) {
        for (File file : directorio.listFiles()) {
            if (file.isDirectory()) {
                indexarDirectorio(file);
            } else {
                indexacion.put(file.getName(), file.getAbsolutePath());
            }
        }
    }

    public String obtenerRuta(String nombreArchivo) {
        return indexacion.get(nombreArchivo);
    }

    public Map<String, String> getIndexacion() {
        return indexacion;
    }
}