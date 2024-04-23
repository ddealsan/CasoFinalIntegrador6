package IndexacionVisualizacionArchivos;

import java.io.File;
import java.util.TreeMap;

public class IndexadorArchivos {
    private TreeMap<String, String> indiceArchivos;

    public IndexadorArchivos() {
        indiceArchivos = new TreeMap<>();
    }

    public void indexarArchivosRecursivamente(File directorio) {
        for (File archivo : directorio.listFiles()) {
            if (archivo.isDirectory()) {
                indexarArchivosRecursivamente(archivo);
            } else {
                indiceArchivos.put(archivo.getName(), archivo.getAbsolutePath());
            }
        }
    }

    public TreeMap<String, String> getIndiceArchivos() {
        return indiceArchivos;
    }
}