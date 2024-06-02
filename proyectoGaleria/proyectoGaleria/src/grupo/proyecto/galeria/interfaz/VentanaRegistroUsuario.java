package grupo.proyecto.galeria.interfaz;

import grupo.proyecto.galeria.consola.UsuarioTipo;

import javax.swing.*;
import java.awt.*;

public class VentanaRegistroUsuario extends JFrame {

    public VentanaRegistroUsuario() {
        setTitle("Registro de Usuario");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;

        JLabel usuarioLabel = new JLabel("Usuario:");
        panel.add(usuarioLabel, gbc);

        gbc.gridx = 1;
        JTextField usuarioField = new JTextField(20);
        panel.add(usuarioField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel contrasenaLabel = new JLabel("Contraseña:");
        panel.add(contrasenaLabel, gbc);

        gbc.gridx = 1;
        JPasswordField contrasenaField = new JPasswordField(20);
        panel.add(contrasenaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel rolLabel = new JLabel("Rol:");
        panel.add(rolLabel, gbc);

        gbc.gridx = 1;
        String[] roles = {"Comprador", "Propietario"};
        JComboBox<String> rolComboBox = new JComboBox<>(roles);
        panel.add(rolComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;

        JButton registrarButton = new JButton("Registrar Usuario");
        panel.add(registrarButton, gbc);

        registrarButton.addActionListener(e -> {
            String usuario = usuarioField.getText();
            String contrasena = new String(contrasenaField.getPassword());
            String rol = (String) rolComboBox.getSelectedItem();

            if (usuario.isEmpty() || contrasena.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Usuario y contraseña no pueden estar vacíos.");
                return;
            }

            UsuarioTipo.registrarUsuario(usuario, contrasena, rol);
            JOptionPane.showMessageDialog(this, "Usuario registrado exitosamente como " + rol);
            dispose(); // Cierra la ventana de registro
        });

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        UsuarioTipo.cargarUsuarios();
        new VentanaRegistroUsuario();
    }
}
