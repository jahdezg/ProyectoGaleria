package grupo.proyecto.galeria.interfazAutor;

import grupo.proyecto.galeria.consola.MenuRoles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ComprarPiezasBoton {
    private JFrame frame;
    private MenuRoles menuRoles;
    private JList<String> piezasList;

    public ComprarPiezasBoton(JFrame frame, MenuRoles menuRoles) {
        this.frame = frame;
        this.menuRoles = menuRoles;
    }

    public JPanel crearPanelComprarPiezas() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel titleLabel = new JLabel("Piezas Disponibles para Comprar:");
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

        JButton comprarButton = new JButton("Comprar");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.NONE;
        panel.add(comprarButton, gbc);

        JButton volverButton = new JButton("Volver");
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(volverButton, gbc);

        comprarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String piezaSeleccionada = piezasList.getSelectedValue();
                if (piezaSeleccionada != null) {
                    String nombrePieza = piezaSeleccionada.split(",")[0].split(":")[1].trim();
                    if (menuRoles.comprarPieza(nombrePieza)) {
                        JOptionPane.showMessageDialog(frame, "La pieza se compró con éxito.");
                        piezasList.setListData(obtenerListaPiezasNoVendidas());
                    } else {
                        JOptionPane.showMessageDialog(frame, "No se encontró ninguna pieza con el nombre especificado o la pieza ya está vendida.");
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Por favor, seleccione una pieza para comprar.");
                }
            }
        });

        volverButton.addActionListener(e -> volverAOpciones());

        return panel;
    }

    private String[] obtenerListaPiezasNoVendidas() {
        List<String> piezas = MenuRoles.mostrarPiezasNoVendidas2();
        return piezas.toArray(new String[0]);
    }

    private void volverAOpciones() {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(new OpcionesBotonesAu(frame).crearPanelOpciones());
        frame.revalidate();
        frame.repaint();
    }
}

