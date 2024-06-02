package grupo.proyecto.galeria.interfazComprador;

import grupo.proyecto.galeria.consola.MenuComprador;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class BotonDefinirMetodoPago extends JPanel {
    private String nombreComprador;

    public BotonDefinirMetodoPago(String nombreComprador) {
        this.nombreComprador = nombreComprador;
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;

        JLabel titleLabel = new JLabel("Seleccione el método de pago:");
        add(titleLabel, gbc);

        JRadioButton efectivoButton = new JRadioButton("Efectivo");
        JRadioButton tarjetaButton = new JRadioButton("Tarjeta");
        JRadioButton transferenciaButton = new JRadioButton("Transferencia");

        ButtonGroup metodoPagoGroup = new ButtonGroup();
        metodoPagoGroup.add(efectivoButton);
        metodoPagoGroup.add(tarjetaButton);
        metodoPagoGroup.add(transferenciaButton);

        gbc.gridy = 1;
        add(efectivoButton, gbc);

        gbc.gridy = 2;
        add(tarjetaButton, gbc);

        gbc.gridy = 3;
        add(transferenciaButton, gbc);

        JButton confirmarButton = new JButton("Confirmar");
        JButton volverButton = new JButton("Volver");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(confirmarButton);
        buttonPanel.add(volverButton);

        gbc.gridy = 4;
        add(buttonPanel, gbc);

        confirmarButton.addActionListener(e -> {
            String metodoPago = null;
            if (efectivoButton.isSelected()) {
                metodoPago = "Efectivo";
            } else if (tarjetaButton.isSelected()) {
                metodoPago = "Tarjeta";
            } else if (transferenciaButton.isSelected()) {
                metodoPago = "Transferencia";
            }

            if (metodoPago != null) {
                MenuComprador.definirMetodoPago(nombreComprador, metodoPago);
                JOptionPane.showMessageDialog(this, "Método de pago registrado con éxito.");
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione un método de pago.");
            }
        });

        volverButton.addActionListener(e -> volverAOpciones());
    }

    private void volverAOpciones() {
        JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        parentFrame.getContentPane().removeAll();
        parentFrame.add(new OpcionesBotones(nombreComprador, new Scanner(System.in)));
        parentFrame.revalidate();
        parentFrame.repaint();
    }
}


