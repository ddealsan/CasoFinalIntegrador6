package MapasAsociacionDatos;

public class RecuperacionEficiente {

    private GestionRelaciones gestionRelaciones;

    public RecuperacionEficiente(GestionRelaciones gestionRelaciones) {
        this.gestionRelaciones = gestionRelaciones;
    }

    public String recuperarTexto(int numero) {
        return gestionRelaciones.obtenerTexto(numero);
    }
}