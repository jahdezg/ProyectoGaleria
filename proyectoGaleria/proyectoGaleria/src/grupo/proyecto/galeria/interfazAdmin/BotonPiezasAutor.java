package grupo.proyecto.galeria.interfazAdmin;

import grupo.proyecto.galeria.consola.MenuRoles;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class BotonPiezasAutor {
    private JFrame frame;
    private MenuRoles menuRoles;
    private JTextField autorField;
    private JList<String> piezasList;

    public BotonPiezasAutor(JFrame frame, MenuRoles menuRoles) {
        this.frame = frame;
        this.menuRoles = menuRoles;
    }

    public JPanel crearPanelBuscarAutor() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel autorLabel = new JLabel("Nombre del autor:");
        autorField = new JTextField(20);

        JButton buscarButton = new JButton("Buscar");
        JButton volverButton = new JButton("Volver");

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(autorLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(autorField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        panel.add(buscarButton, gbc);

        piezasList = new JList<>();
        JScrollPane scrollPane = new JScrollPane(piezasList);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        panel.add(scrollPane, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.NONE;
        panel.add(volverButton, gbc);

        buscarButton.addActionListener(e -> buscarPiezasPorAutor());
        volverButton.addActionListener(e -> volverAOpciones());

        return panel;
    }

    private void buscarPiezasPorAutor() {
        String autor = autorField.getText().trim();
        if (autor.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Por favor, ingrese el nombre del autor.");
            return;
        }

        List<String> piezas = MenuRoles.buscarPiezasPorAutor(autor);
        piezasList.setListData(piezas.toArray(new String[0]));

        if (piezas.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "No se encontraron piezas para el autor: " + autor);
        }
    }

    private void volverAOpciones() {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(new OpcionesBotones(frame).crearPanelOpciones());
        frame.revalidate();
        frame.repaint();
    }
}

