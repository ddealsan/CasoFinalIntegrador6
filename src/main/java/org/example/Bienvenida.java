package org.example;

import GestionDatosDinamicos.VentanaGestionDatos;
import AnalisisOrganizacionInformacion.VentanaAnalisisOrganizacion;
import AnalisisOrganizacionInformacion.Venta; // Import Venta class
import MapasAsociacionDatos.VentanaMapasAsociacion;
import IndexacionVisualizacionArchivos.VentanaIndexacionVisualizacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList; // Import ArrayList
import java.util.List; // Import List

public class Bienvenida extends JFrame {
    public Bienvenida() {
        setTitle("Bienvenido");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setLayout(new GridLayout(1, 2));

        // Panel izquierdo
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BorderLayout());
        leftPanel.setBackground(Color.WHITE);

        // Cargar imagen
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/FotoLogo.png"));
        Image image = imageIcon.getImage();
        Image scaledImage = image.getScaledInstance(450, 300, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(scaledImage);
        JLabel imageLabel = new JLabel(imageIcon);
        leftPanel.add(imageLabel, BorderLayout.NORTH);

        // Texto de bienvenida
        JLabel welcomeLabel = new JLabel("<html><div style='text-align: center;'>Bienvenido al Sistema de Gestión y Análisis de Datos Multidimensionales</div></html>", SwingConstants.CENTER);
        welcomeLabel.setForeground(Color.BLUE);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 30));
        leftPanel.add(welcomeLabel, BorderLayout.CENTER);

        // Panel derecho
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(5, 1));
        rightPanel.setBackground(Color.DARK_GRAY);

        // Botones
        JButton button1 = new JButton("Gestión de datos dinámicos");
        button1.setForeground(Color.WHITE);
        button1.setBackground(Color.BLUE);
        button1.setFont(new Font("Arial", Font.BOLD, 20));
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VentanaGestionDatos().setVisible(true);
                dispose();
            }
        });
        rightPanel.add(button1);

        JButton button2 = new JButton("Análisis y organización de información");
        button2.setForeground(Color.WHITE);
        button2.setBackground(Color.BLUE);
        button2.setFont(new Font("Arial", Font.BOLD, 20));
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Venta> ventas = new ArrayList<>(); // Create an empty list
                new VentanaAnalisisOrganizacion(ventas).setVisible(true); // Pass the list to the constructor
                dispose();
            }
        });
        rightPanel.add(button2);

        JButton button3 = new JButton("Mapas y Asociación de Datos");
        button3.setForeground(Color.WHITE);
        button3.setBackground(Color.BLUE);
        button3.setFont(new Font("Arial", Font.BOLD, 20));
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VentanaMapasAsociacion().setVisible(true);
                dispose();
            }
        });
        rightPanel.add(button3);

        JButton button4 = new JButton("Indexación y Visualización de Archivos");
        button4.setForeground(Color.WHITE);
        button4.setBackground(Color.BLUE);
        button4.setFont(new Font("Arial", Font.BOLD, 20));
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VentanaIndexacionVisualizacion().setVisible(true);
                dispose();
            }
        });
        rightPanel.add(button4);

        JButton buttonSalir = new JButton("Salir");
        buttonSalir.setForeground(Color.WHITE);
        buttonSalir.setBackground(Color.BLUE);
        buttonSalir.setFont(new Font("Arial", Font.BOLD, 20));
        buttonSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        rightPanel.add(buttonSalir);

        // Añadir paneles al JFrame
        add(leftPanel);
        add(rightPanel);
    }
}