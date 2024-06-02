package grupo.proyecto.galeria.interfazComprador;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class OpcionesBotones extends JPanel {
    private String nombreComprador;
    private Scanner scanner;

    public OpcionesBotones(String nombreComprador, Scanner scanner) {
        this.nombreComprador = nombreComprador;
        this.scanner = scanner;

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        JButton comprarButton = new JButton("Comprar piezas");
        JButton definirPagoButton = new JButton("Definir método de pago");
        JButton participarSubastaButton = new JButton("Participar en subasta");
        JButton verPendientesButton = new JButton("Ver solicitudes o compras pendientes");
        JButton verHistorialButton = new JButton("Ver historial de todas las piezas");
        JButton salirButton = new JButton("Salir");

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(comprarButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(definirPagoButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(participarSubastaButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(verPendientesButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(verHistorialButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        add(salirButton, gbc);

        comprarButton.addActionListener(e -> mostrarComprarPiezas());
        definirPagoButton.addActionListener(e -> mostrarDefinirMetodoPago());
        participarSubastaButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Opción en desarrollo."));
        verPendientesButton.addActionListener(e -> mostrarPendientes());
        verHistorialButton.addActionListener(e -> mostrarHistorialPiezas());
        salirButton.addActionListener(e -> ((JFrame) SwingUtilities.getWindowAncestor(this)).dispose());
    }

    private void mostrarComprarPiezas() {
        JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        parentFrame.getContentPane().removeAll();
        parentFrame.add(new BotonComprarPiezas(nombreComprador));
        parentFrame.revalidate();
        parentFrame.repaint();
    }

    private void mostrarDefinirMetodoPago() {
        JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        parentFrame.getContentPane().removeAll();
        parentFrame.add(new BotonDefinirMetodoPago(nombreComprador));
        parentFrame.revalidate();
        parentFrame.repaint();
    }

    private void mostrarPendientes() {
        JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        parentFrame.getContentPane().removeAll();
        parentFrame.add(new BotonVerPendientes(nombreComprador));
        parentFrame.revalidate();
        parentFrame.repaint();
    }

    private void mostrarHistorialPiezas() {
        JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        parentFrame.getContentPane().removeAll();
        parentFrame.add(new BotonHistorialPiezas());
        parentFrame.revalidate();
        parentFrame.repaint();
    }
}

