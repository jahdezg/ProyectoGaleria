package grupo.proyecto.galeria.interfazComprador;

import grupo.proyecto.galeria.consola.MenuComprador;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class BotonComprarPiezas extends JPanel {
    private String nombreComprador;

    public BotonComprarPiezas(String nombreComprador) {
        this.nombreComprador = nombreComprador;
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Piezas Disponibles para Comprar:");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(titleLabel, BorderLayout.NORTH);

        DefaultListModel<String> piezasModel = obtenerPiezasNoVendidas();
        JList<String> piezasList = new JList<>(piezasModel);
        JScrollPane scrollPane = new JScrollPane(piezasList);
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton comprarButton = new JButton("Comprar");
        JButton volverButton = new JButton("Volver");
        buttonPanel.add(comprarButton);
        buttonPanel.add(volverButton);
        add(buttonPanel, BorderLayout.SOUTH);

        comprarButton.addActionListener(e -> {
            String piezaSeleccionada = piezasList.getSelectedValue();
            if (piezaSeleccionada != null) {
                boolean exito = MenuComprador.comprarPieza(piezaSeleccionada, nombreComprador);
                if (exito) {
                    JOptionPane.showMessageDialog(this, "La pieza se compró con éxito.");
                    piezasModel.removeElement(piezaSeleccionada);
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo comprar la pieza. Intente nuevamente.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione una pieza para comprar.");
            }
        });

        volverButton.addActionListener(e -> volverAOpciones());
    }

    private DefaultListModel<String> obtenerPiezasNoVendidas() {
        DefaultListModel<String> piezasModel = new DefaultListModel<>();
        try (BufferedReader br = new BufferedReader(new FileReader(MenuComprador.PIEZAS_FILE_PATH))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(":");
                if (partes.length >= 7 && partes[5].equalsIgnoreCase("false")) {
                    piezasModel.addElement(linea);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar las piezas disponibles: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return piezasModel;
    }

    private void volverAOpciones() {
        JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        parentFrame.getContentPane().removeAll();
        parentFrame.add(new OpcionesBotones(nombreComprador, new Scanner(System.in)));
        parentFrame.revalidate();
        parentFrame.repaint();
    }
}

