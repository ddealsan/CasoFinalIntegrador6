package AnalisisOrganizacionInformacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogoNuevaVenta extends JDialog {
    private JTextField campoProducto;
    private JTextField campoCantidad;
    private JTextField campoPrecio;
    private JButton botonGuardar;

    public DialogoNuevaVenta(Frame owner) {
        super(owner, "Nueva Venta", true);

        setLayout(new GridLayout(4, 2));

        add(new JLabel("Producto:"));
        campoProducto = new JTextField();
        add(campoProducto);

        add(new JLabel("Cantidad:"));
        campoCantidad = new JTextField();
        add(campoCantidad);

        add(new JLabel("Precio:"));
        campoPrecio = new JTextField();
        add(campoPrecio);

        botonGuardar = new JButton("Guardar");
        botonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes agregar el código para guardar la nueva venta
                // Por ejemplo, podrías agregar la nueva venta a la lista de ventas
                dispose();
            }
        });
        add(botonGuardar);

        pack();
        setLocationRelativeTo(owner);
    }

    public Venta getNuevaVenta() {
        String producto = campoProducto.getText();
        int cantidad = Integer.parseInt(campoCantidad.getText());
        double precio = Double.parseDouble(campoPrecio.getText());
        return new Venta(producto, cantidad, precio);
    }
}