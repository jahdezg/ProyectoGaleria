package grupo.proyecto.galeria.interfazAdmin;

import grupo.proyecto.galeria.consola.MenuRoles;
import javax.swing.*;
import java.awt.*;

public class BotonPiezaNueva {
    private JFrame frame;
    private MenuRoles menuRoles;

    public BotonPiezaNueva(JFrame frame, MenuRoles menuRoles) {
        this.frame = frame;
        this.menuRoles = menuRoles;
    }

    public JPanel crearPanelRegistro() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel nombreLabel = new JLabel("Nombre de la pieza:");
        JTextField nombreField = new JTextField(20);

        JLabel autorLabel = new JLabel("Autor:");
        JTextField autorField = new JTextField(20);

        JLabel propietarioLabel = new JLabel("Nombre del propietario:");
        JTextField propietarioField = new JTextField(20);

        JLabel anoLabel = new JLabel("Año de creación:");
        JTextField anoField = new JTextField(4);

        JLabel tipoLabel = new JLabel("Tipo de pieza (Escultura, Fotografia, Impresion, Pintura, Video):");
        JTextField tipoField = new JTextField(20);

        JLabel vendidaLabel = new JLabel("¿La pieza se vendió? (Si/No):");
        JTextField vendidaField = new JTextField(3);

        JLabel precioVentaLabel = new JLabel("Precio de venta:");
        JTextField precioVentaField = new JTextField(10);

        JLabel fechaCompraLabel = new JLabel("Fecha de compra (dd/mm/yyyy):");
        JTextField fechaCompraField = new JTextField(10);

        JLabel horaCompraLabel = new JLabel("Hora de compra (HH:MM):");
        JTextField horaCompraField = new JTextField(5);

        JLabel metodoPagoLabel = new JLabel("Método de pago (Fijo/Subasta/Ninguno):");
        JTextField metodoPagoField = new JTextField(10);

        JLabel precioLabel = new JLabel("Precio:");
        JTextField precioField = new JTextField(10);

        JLabel precioMinimoLabel = new JLabel("Precio mínimo (subasta):");
        JTextField precioMinimoField = new JTextField(10);

        JLabel descripcionLabel = new JLabel("Descripción:");
        JTextArea descripcionArea = new JTextArea(5, 20);

        JButton registrarButton = new JButton("Registrar");
        JButton cancelarButton = new JButton("Cancelar");

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(nombreLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(nombreField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(autorLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(autorField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(propietarioLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(propietarioField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(anoLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(anoField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(tipoLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(tipoField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(vendidaLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        panel.add(vendidaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(precioVentaLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        panel.add(precioVentaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(fechaCompraLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        panel.add(fechaCompraField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        panel.add(horaCompraLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 8;
        panel.add(horaCompraField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 9;
        panel.add(metodoPagoLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 9;
        panel.add(metodoPagoField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 10;
        panel.add(precioLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 10;
        panel.add(precioField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 11;
        panel.add(precioMinimoLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 11;
        panel.add(precioMinimoField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 12;
        panel.add(descripcionLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 13;
        gbc.gridwidth = 2;
        panel.add(new JScrollPane(descripcionArea), gbc);

        gbc.gridx = 0;
        gbc.gridy = 14;
        gbc.gridwidth = 1;
        panel.add(registrarButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 14;
        panel.add(cancelarButton, gbc);

        cancelarButton.addActionListener(e -> volverAOpciones());

        registrarButton.addActionListener(e -> {
            registrarPieza(nombreField, autorField, propietarioField, anoField, tipoField, vendidaField, precioVentaField, fechaCompraField, horaCompraField, metodoPagoField, precioField, precioMinimoField, descripcionArea);
            volverAOpciones();
        });

        JScrollPane scrollPane = new JScrollPane(panel);
        JPanel scrollPanel = new JPanel(new BorderLayout());
        scrollPanel.add(scrollPane, BorderLayout.CENTER);

        return scrollPanel;
    }

    private void registrarPieza(JTextField nombreField, JTextField autorField, JTextField propietarioField, JTextField anoField, JTextField tipoField, JTextField vendidaField, JTextField precioVentaField, JTextField fechaCompraField, JTextField horaCompraField, JTextField metodoPagoField, JTextField precioField, JTextField precioMinimoField, JTextArea descripcionArea) {
        String nombre = nombreField.getText();
        String autor = autorField.getText();
        String propietario = propietarioField.getText();
        int ano = Integer.parseInt(anoField.getText());
        String tipo = tipoField.getText();
        boolean vendida = vendidaField.getText().equalsIgnoreCase("Si");
        double precioVenta = vendida ? Double.parseDouble(precioVentaField.getText()) : 0.0;
        String fechaCompra = vendida ? fechaCompraField.getText() : "";
        String horaCompra = vendida ? horaCompraField.getText() : "";
        String metodoPago = metodoPagoField.getText();
        double precio = metodoPago.equals("fijo") && !vendida ? Double.parseDouble(precioField.getText()) : 0.0;
        double precioMinimo = metodoPago.equals("subasta") ? Double.parseDouble(precioMinimoField.getText()) : 0.0;
        String descripcion = descripcionArea.getText();

        MenuRoles.guardarPieza(nombre, autor, propietario, ano, tipo, vendida, metodoPago, precio, precioMinimo, precioVenta, fechaCompra, horaCompra, descripcion);

        JOptionPane.showMessageDialog(frame, "Pieza registrada con éxito.");
    }

    private void volverAOpciones() {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(new OpcionesBotones(frame).crearPanelOpciones());
        frame.revalidate();
        frame.repaint();
    }
}



