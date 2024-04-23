package AnalisisOrganizacionInformacion;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VentanaAnalisisOrganizacion extends JFrame {
    private AnalisisRegistros analisisRegistros;
    private JTable tablaVentas;

    public VentanaAnalisisOrganizacion(List<Venta> ventas) {
        this.analisisRegistros = new AnalisisRegistros(ventas);

        setTitle("Análisis y Organización de Información");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Crear la tabla de ventas
        tablaVentas = new JTable();
        JScrollPane scrollPane = new JScrollPane(tablaVentas);
        add(scrollPane, BorderLayout.CENTER);

        // Crear los botones de ordenación y búsqueda
        JPanel panelBotones = new JPanel();
        JButton botonOrdenarProducto = new JButton("Ordenar por producto");
        botonOrdenarProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                analisisRegistros.ordenarVentasPorProducto();
                actualizarTabla();
            }
        });
        panelBotones.add(botonOrdenarProducto);

        JButton botonOrdenarCantidad = new JButton("Ordenar por cantidad");
        botonOrdenarCantidad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                analisisRegistros.ordenarVentasPorCantidad();
                actualizarTabla();
            }
        });
        panelBotones.add(botonOrdenarCantidad);

        JButton botonNuevaVenta = new JButton("Nueva Venta");
        botonNuevaVenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DialogoNuevaVenta dialogo = new DialogoNuevaVenta(VentanaAnalisisOrganizacion.this);
                dialogo.setVisible(true);
                Venta nuevaVenta = dialogo.getNuevaVenta();
                analisisRegistros.getVentas().add(nuevaVenta);
                actualizarTabla();
            }
        });
        panelBotones.add(botonNuevaVenta);

        JButton botonBorrarVenta = new JButton("Borrar Venta");
        botonBorrarVenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int filaSeleccionada = tablaVentas.getSelectedRow();
                if (filaSeleccionada >= 0) {
                    analisisRegistros.getVentas().remove(filaSeleccionada);
                    actualizarTabla();
                }
            }
        });
        panelBotones.add(botonBorrarVenta);

        add(panelBotones, BorderLayout.SOUTH);

        // Actualizar la tabla con las ventas iniciales
        actualizarTabla();
    }

    private void actualizarTabla() {
        DefaultTableModel model = new DefaultTableModel(new Object[]{"Producto", "Cantidad", "Precio"}, 0);
        for (Venta venta : analisisRegistros.getVentas()) {
            model.addRow(new Object[]{venta.getProducto(), venta.getCantidad(), venta.getPrecio()});
        }
        tablaVentas.setModel(model);
    }
}