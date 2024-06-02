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

        JButton revisarPiezaButton = new JButton("Revisar piezas registradas a su nombre");
        JButton estadoSubastaButton = new JButton("Revisar estado de subasta (Opción en desarrollo)");
        JButton comprarPiezasButton = new JButton("Comprar piezas");
        JButton salirButton = new JButton("Salir");

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(revisarPiezaButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(estadoSubastaButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(comprarPiezasButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(salirButton, gbc);

        revisarPiezaButton.addActionListener(e -> mostrarPantallaBuscarPiezasAutor());
        salirButton.addActionListener(e -> frame.dispose());
        
        estadoSubastaButton.addActionListener(e -> mostrarMensajeEnDesarrollo());
        salirButton.addActionListener(e -> frame.dispose());

        return panel;
    }

    private void mostrarPantallaBuscarPiezasAutor() {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(new BotonNombre(frame, menuRoles).crearPanelBuscarAutor());
        frame.revalidate();
        frame.repaint();
    }
    private void mostrarMensajeEnDesarrollo() {
        JOptionPane.showMessageDialog(frame, "Opción en desarrollo", "Información", JOptionPane.INFORMATION_MESSAGE);
    }
}

