package grupo.proyecto.galeria.interfazAdmin;

import grupo.proyecto.galeria.consola.MenuRoles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class BotonEliminarPieza {
    private JFrame frame;
    private MenuRoles menuRoles;
    private JList<String> piezasList;

    public BotonEliminarPieza(JFrame frame, MenuRoles menuRoles) {
        this.frame = frame;
        this.menuRoles = menuRoles;
    }

    public JPanel crearPanelEliminar() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel titleLabel = new JLabel("Selecciona la pieza que deseas eliminar:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(titleLabel, gbc);

        piezasList = new JList<>(obtenerListaPiezas());
        JScrollPane scrollPane = new JScrollPane(piezasList);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        panel.add(scrollPane, gbc);

        JButton eliminarButton = new JButton("Eliminar pieza");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.NONE;
        panel.add(eliminarButton, gbc);

        JButton cancelarButton = new JButton("Cancelar");
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(cancelarButton, gbc);

        cancelarButton.addActionListener(e -> volverAOpciones());
        eliminarButton.addActionListener(e -> confirmarEliminarPieza());

        return panel;
    }

    private void confirmarEliminarPieza() {
        int selectedIndex = piezasList.getSelectedIndex();
        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(frame, "Por favor, seleccione una pieza para eliminar.");
            return;
        }

        int response = JOptionPane.showConfirmDialog(frame, "¿Estás seguro de que deseas eliminar esta pieza?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            eliminarPieza(selectedIndex);
        }
    }

    private void eliminarPieza(int index) {
        MenuRoles.eliminarPiezaPorID(index + 1); // +1 porque la lista es 0-based y nuestras IDs son 1-based
        JOptionPane.showMessageDialog(frame, "Pieza eliminada correctamente.");
        volverAOpciones();
    }

    private String[] obtenerListaPiezas() {
        List<String> piezas = MenuRoles.mostrarPiezasConID();
        return piezas.toArray(new String[0]);
    }

    private void volverAOpciones() {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(new OpcionesBotones(frame).crearPanelOpciones());
        frame.revalidate();
        frame.repaint();
    }
}
