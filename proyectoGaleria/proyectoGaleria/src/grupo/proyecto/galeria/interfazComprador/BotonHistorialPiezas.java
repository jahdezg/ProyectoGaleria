package grupo.proyecto.galeria.interfazComprador;

import grupo.proyecto.galeria.consola.MenuComprador;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BotonHistorialPiezas extends JPanel {
    public BotonHistorialPiezas() {
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;

        JLabel titleLabel = new JLabel("Historial de todas las piezas:");
        add(titleLabel, gbc);

        DefaultListModel<String> piezasListModel = new DefaultListModel<>();
        JList<String> piezasList = new JList<>(piezasListModel);
        JScrollPane scrollPane = new JScrollPane(piezasList);

        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 1;
        add(scrollPane, gbc);

        JButton volverButton = new JButton("Volver");
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        gbc.weighty = 0;
        add(volverButton, gbc);

        volverButton.addActionListener(e -> volverAOpciones());

        cargarHistorialPiezas(piezasListModel);
    }

    private void cargarHistorialPiezas(DefaultListModel<String> piezasListModel) {
        try (BufferedReader br = new BufferedReader(new FileReader(MenuComprador.PIEZAS_FILE_PATH))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                piezasListModel.addElement(linea);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar el historial de piezas: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void volverAOpciones() {
        JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        parentFrame.getContentPane().removeAll();
        parentFrame.add(new OpcionesBotones("", new Scanner(System.in))); 
        parentFrame.revalidate();
        parentFrame.repaint();
    }
}


