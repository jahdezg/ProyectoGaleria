package grupo.proyecto.galeria.interfazAdmin;

import grupo.proyecto.galeria.consola.MenuRoles;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class BotonNoVendidas {
    private JFrame frame;
    private MenuRoles menuRoles;
    private JList<String> piezasList;

    public BotonNoVendidas(JFrame frame, MenuRoles menuRoles) {
        this.frame = frame;
        this.menuRoles = menuRoles;
    }

    public JPanel crearPanelMostrarNoVendidas() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel titleLabel = new JLabel("Piezas No Vendidas:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(titleLabel, gbc);

        piezasList = new JList<>(obtenerListaPiezasNoVendidas());
        JScrollPane scrollPane = new JScrollPane(piezasList);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        panel.add(scrollPane, gbc);

        JButton volverButton = new JButton("Volver");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.NONE;
        panel.add(volverButton, gbc);

        volverButton.addActionListener(e -> volverAOpciones());

        return panel;
    }

    private String[] obtenerListaPiezasNoVendidas() {
        List<String> piezas = MenuRoles.mostrarPiezasNoVendidas2();
        return piezas.toArray(new String[0]);
    }

    private void volverAOpciones() {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(new OpcionesBotones(frame).crearPanelOpciones());
        frame.revalidate();
        frame.repaint();
    }
}


 