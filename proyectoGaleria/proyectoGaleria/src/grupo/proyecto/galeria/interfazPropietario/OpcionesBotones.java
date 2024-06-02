package grupo.proyecto.galeria.interfazPropietario;

import javax.swing.*;
import java.awt.*;

public class OpcionesBotones {
    private JFrame frame;

    public OpcionesBotones(JFrame frame) {
        this.frame = frame;
    }

    public JPanel crearPanelOpciones() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        JButton historialButton = new JButton("Mirar historial de piezas");
        JButton subastaButton = new JButton("Participar en subasta (Opción en desarrollo)");
        JButton comprarButton = new JButton("Comprar pieza");
        JButton salirButton = new JButton("Salir");

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(historialButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(subastaButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(comprarButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(salirButton, gbc);

        historialButton.addActionListener(e -> mostrarHistorial());
        subastaButton.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Opción en desarrollo."));
        comprarButton.addActionListener(e -> comprarPieza());
        salirButton.addActionListener(e -> frame.dispose());

        return panel;
    }

    private void mostrarHistorial() {
        new BotonHistorialPiezas(frame).setVisible(true);
        frame.setVisible(false);
    }

    private void comprarPieza() {
        new BotonComprarPieza(frame).setVisible(true);
        frame.setVisible(false);
    }
}

