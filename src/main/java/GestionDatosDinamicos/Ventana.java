package GestionDatosDinamicos;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    private ListaDatos listaDatos;

    public Ventana() {
        listaDatos = new ListaDatos();

        setTitle("Gestión de Datos Dinámicos");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        JTextField textFieldPrimero = new JTextField(10);
        JTextField textFieldSegundo = new JTextField(10);
        JButton buttonAgregar = new JButton("Agregar");
        JButton buttonEliminar = new JButton("Eliminar");
        JButton buttonMostrar = new JButton("Mostrar todos");

        buttonAgregar.addActionListener(e -> {
            int primero = Integer.parseInt(textFieldPrimero.getText());
            int segundo = Integer.parseInt(textFieldSegundo.getText());
            Pareja pareja = new Pareja(primero, segundo);
            listaDatos.agregarDato(pareja);
            textFieldPrimero.setText("");
            textFieldSegundo.setText("");
        });

        buttonEliminar.addActionListener(e -> {
            int primero = Integer.parseInt(textFieldPrimero.getText());
            int segundo = Integer.parseInt(textFieldSegundo.getText());
            Pareja pareja = new Pareja(primero, segundo);
            listaDatos.eliminarDato(pareja);
            textFieldPrimero.setText("");
            textFieldSegundo.setText("");
        });

        buttonMostrar.addActionListener(e -> {
            textArea.setText("");
            for (Object dato : listaDatos.getDatos()) {
                textArea.append(dato.toString() + "\n");
            }
        });

        panel.add(textFieldPrimero);
        panel.add(textFieldSegundo);
        panel.add(buttonAgregar);
        panel.add(buttonEliminar);
        panel.add(buttonMostrar);
        add(panel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ventana().setVisible(true));
    }
}