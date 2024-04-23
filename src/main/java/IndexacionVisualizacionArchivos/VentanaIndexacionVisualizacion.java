package IndexacionVisualizacionArchivos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Map;

public class VentanaIndexacionVisualizacion extends JFrame {
    private IndexadorArchivos indexadorArchivos;
    private JTextArea textArea;

    public VentanaIndexacionVisualizacion() {
        indexadorArchivos = new IndexadorArchivos();

        setTitle("Indexación y Visualización de Archivos");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel();

        JButton botonIndexar = new JButton("Indexar Archivos");
        botonIndexar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int seleccion = fileChooser.showOpenDialog(null);
                if (seleccion == JFileChooser.APPROVE_OPTION) {
                    File directorio = fileChooser.getSelectedFile();
                    indexadorArchivos.indexarArchivosRecursivamente(directorio);
                    actualizarTextArea();
                }
            }
        });
        panelBotones.add(botonIndexar);

        add(panelBotones, BorderLayout.SOUTH);
    }

    private void actualizarTextArea() {
        textArea.setText("");
        for (Map.Entry<String, String> entrada : indexadorArchivos.getIndiceArchivos().entrySet()) {
            textArea.append(entrada.getKey() + ": " + entrada.getValue() + "\n");
        }
    }
}