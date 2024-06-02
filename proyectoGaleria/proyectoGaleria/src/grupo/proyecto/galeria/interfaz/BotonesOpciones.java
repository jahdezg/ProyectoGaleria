package grupo.proyecto.galeria.interfaz;

import javax.swing.*;
import java.awt.*;

public class BotonesOpciones {

    private JPanel panel;

    public BotonesOpciones() {
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;

        Dimension buttonSize = new Dimension(200, 40); // Tamaño preferido para los botones

        JButton btnIniciarSesion = new JButton("Iniciar Sesion");
        btnIniciarSesion.setPreferredSize(buttonSize);
        panel.add(btnIniciarSesion, gbc);

        gbc.gridy++;
        JButton btnRegistrarUsuario = new JButton("Registrar Usuario");
        btnRegistrarUsuario.setPreferredSize(buttonSize);
        panel.add(btnRegistrarUsuario, gbc);

        gbc.gridy++;
        JButton btnSalir = new JButton("Salir");
        btnSalir.setPreferredSize(buttonSize);
        panel.add(btnSalir, gbc);

        btnIniciarSesion.addActionListener(e -> new VentanaInicioSesion());

        btnRegistrarUsuario.addActionListener(e -> new VentanaRegistroUsuario());

        btnSalir.addActionListener(e -> System.exit(0));
    }

    public JPanel getPanel() {
        return panel;
    }
}

