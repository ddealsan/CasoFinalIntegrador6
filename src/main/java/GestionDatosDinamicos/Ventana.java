package GestionDatosDinamicos;

import org.example.Bienvenida;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ventana extends JFrame {
    private ListaDatos listaDatos;
    private JList<Pareja> listaParejas;

    public Ventana() {
        listaDatos = new ListaDatos();
        listaDatos.cargarDatos(); // Cargar los datos al iniciar la ventana

        setTitle("Gestión de Datos Dinámicos");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        listaParejas = new JList<>();
        JScrollPane scrollPane = new JScrollPane(listaParejas);
        add(scrollPane, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        JTextField textFieldPrimero = new JTextField(10);
        JTextField textFieldSegundo = new JTextField(10);
        JButton buttonAgregar = new JButton("Agregar");
        JButton buttonEliminar = new JButton("Eliminar");

        buttonAgregar.addActionListener(e -> {
            int primero = Integer.parseInt(textFieldPrimero.getText());
            int segundo = Integer.parseInt(textFieldSegundo.getText());
            Pareja pareja = new Pareja(primero, segundo);
            listaDatos.agregarDato(pareja);
            textFieldPrimero.setText("");
            textFieldSegundo.setText("");
            actualizarListaParejas();
        });

        buttonEliminar.addActionListener(e -> {
            Pareja parejaSeleccionada = listaParejas.getSelectedValue();
            if (parejaSeleccionada != null) {
                listaDatos.eliminarDato(parejaSeleccionada);
                actualizarListaParejas();
            }
        });

        JButton buttonSalir = new JButton("Salir");
        buttonSalir.addActionListener(e -> {
            listaDatos.guardarDatos(); // Guardar los datos al presionar el botón de salida
            dispose();
            new Bienvenida().setVisible(true); // Abrir la ventana principal
        });
        panel.add(buttonSalir);

        panel.add(textFieldPrimero);
        panel.add(textFieldSegundo);
        panel.add(buttonAgregar);
        panel.add(buttonEliminar);
        add(panel, BorderLayout.SOUTH);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                listaDatos.guardarDatos(); // Guardar los datos al cerrar la ventana
            }
        });
    }

    private void actualizarListaParejas() {
        DefaultListModel<Pareja> model = new DefaultListModel<>();
        for (Pareja pareja : listaDatos.getDatos()) {
            model.addElement(pareja);
        }
        listaParejas.setModel(model);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ventana().setVisible(true));
    }
}