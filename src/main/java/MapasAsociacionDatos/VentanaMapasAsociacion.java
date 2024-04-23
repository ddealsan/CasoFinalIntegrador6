package MapasAsociacionDatos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaMapasAsociacion extends JFrame {
    private GestionMapas gestionMapas;
    private JTextArea textArea;

    public VentanaMapasAsociacion() {
        gestionMapas = new GestionMapas();

        setTitle("Mapas y Asociación de Datos");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel();

        JButton botonAgregar = new JButton("Agregar Elemento");
        botonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String claveString = JOptionPane.showInputDialog("Ingrese la clave:");
                String valor = JOptionPane.showInputDialog("Ingrese el valor:");
                int clave = Integer.parseInt(claveString);
                gestionMapas.agregarElemento(clave, valor);
                textArea.append("Elemento agregado: Clave = " + clave + ", Valor = " + valor + "\n");
            }
        });
        panelBotones.add(botonAgregar);

        JButton botonRecuperar = new JButton("Recuperar Elemento");
        botonRecuperar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String claveString = JOptionPane.showInputDialog("Ingrese la clave:");
                int clave = Integer.parseInt(claveString);
                String valor = gestionMapas.recuperarElemento(clave);
                if (valor != null) {
                    textArea.append("El valor para la clave " + clave + " es: " + valor + "\n");
                } else {
                    textArea.append("No se encontró ningún valor para la clave " + clave + "\n");
                }
            }
        });
        panelBotones.add(botonRecuperar);

        add(panelBotones, BorderLayout.SOUTH);
    }
}