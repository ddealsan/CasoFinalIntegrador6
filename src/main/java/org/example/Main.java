package org.example;

import GestionDatosDinamicos.Ventana;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Bienvenida().setVisible(true));
    }
}

class Bienvenida extends JFrame {
    public Bienvenida() {
        setTitle("Bienvenido");
        setSize(600, 400);
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
        Image scaledImage = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(scaledImage);
        JLabel imageLabel = new JLabel(imageIcon);
        leftPanel.add(imageLabel, BorderLayout.NORTH);

        // Texto de bienvenida
        JLabel welcomeLabel = new JLabel("<html><div style='text-align: center;'>Bienvenido al Sistema de Gestión y Análisis de Datos Multidimensionales</div></html>", SwingConstants.CENTER);
        welcomeLabel.setForeground(Color.BLUE);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        leftPanel.add(welcomeLabel, BorderLayout.CENTER);

        // Panel derecho
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(2, 1));
        rightPanel.setBackground(Color.DARK_GRAY);

        // Botones
        JButton button1 = new JButton("Gestión de datos dinámicos");
        button1.setForeground(Color.WHITE);
        button1.setBackground(Color.BLUE);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Ventana().setVisible(true);
                dispose();
            }
        });
        rightPanel.add(button1);

        JButton button2 = new JButton("Análisis y organización de información");
        button2.setForeground(Color.WHITE);
        button2.setBackground(Color.BLUE);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes agregar la acción para el segundo botón
            }
        });
        rightPanel.add(button2);

        // Añadir paneles al JFrame
        add(leftPanel);
        add(rightPanel);
    }
}