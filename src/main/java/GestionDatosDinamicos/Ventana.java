// En Ventana.java
package GestionDatosDinamicos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame {
    private ListaDatos listaDatos;
    private JList<Pareja> listaParejas;

    public Ventana() {
        listaDatos = new ListaDatos();

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

        panel.add(textFieldPrimero);
        panel.add(textFieldSegundo);
        panel.add(buttonAgregar);
        panel.add(buttonEliminar);
        add(panel, BorderLayout.SOUTH);
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