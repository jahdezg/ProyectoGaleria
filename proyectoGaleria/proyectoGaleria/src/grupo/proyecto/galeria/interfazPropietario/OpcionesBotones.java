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
        panel.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        JButton historialButton = crearBoton("Mirar historial de piezas");
        JButton subastaButton = crearBoton("Participar en subasta (Opción en desarrollo)");
        JButton comprarButton = crearBoton("Comprar pieza");
        JButton salirButton = crearBoton("Salir");

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

    private JButton crearBoton(String texto) {
        BotonRedondeado boton = new BotonRedondeado(texto);
        boton.setPreferredSize(new Dimension(200, 100));
        boton.setBackground(new Color(0, 0, 0, 180)); // Fondo negro con algo de transparencia
        boton.setForeground(Color.WHITE); // Texto blanco
        return boton;
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

