package GestionDatosDinamicos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ListaDatos implements Serializable {
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

    public void guardarDatos() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("datos.ser"))) {
            oos.writeObject(datos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarDatos() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("datos.ser"))) {
            datos = (List<Pareja>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}