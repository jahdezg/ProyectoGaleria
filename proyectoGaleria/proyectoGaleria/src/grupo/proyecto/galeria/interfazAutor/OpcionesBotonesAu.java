package grupo.proyecto.galeria.interfazAutor;

import javax.swing.*;
import java.awt.*;
import grupo.proyecto.galeria.consola.MenuRoles;

public class OpcionesBotonesAu {
    private JFrame frame;
    private MenuRoles menuRoles;

    public OpcionesBotonesAu(JFrame frame) {
        this.frame = frame;
        this.menuRoles = new MenuRoles();
    }

    public JPanel crearPanelOpciones() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        JButton manejarSubastaBoton = new JButton("Manejar subasta (Opción en desarrollo)");
        JButton salirButton = new JButton("Salir");

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(manejarSubastaBoton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(salirButton, gbc);

        manejarSubastaBoton.addActionListener(e -> mostrarMensajeEnDesarrollo());
        salirButton.addActionListener(e -> frame.dispose());

        return panel;
    }

    private void mostrarMensajeEnDesarrollo() {
        JOptionPane.showMessageDialog(frame, "Opción en desarrollo", "Información", JOptionPane.INFORMATION_MESSAGE);
    }
}
