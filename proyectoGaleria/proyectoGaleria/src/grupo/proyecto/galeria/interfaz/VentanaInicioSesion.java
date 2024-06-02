package grupo.proyecto.galeria.interfaz;

import grupo.proyecto.galeria.consola.UsuarioTipo;

import javax.swing.*;
import java.awt.*;

public class VentanaInicioSesion extends JFrame {

    public VentanaInicioSesion() {
        setTitle("Iniciar Sesión");
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
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;

        JButton iniciarSesionButton = new JButton("Iniciar Sesión");
        panel.add(iniciarSesionButton, gbc);

        iniciarSesionButton.addActionListener(e -> {
            String usuario = usuarioField.getText();
            String contrasena = new String(contrasenaField.getPassword());
            boolean exito = UsuarioTipo.iniciarSesion(usuario, contrasena);
            if (exito) {
                String rol = UsuarioTipo.obtenerRol(usuario);
                JOptionPane.showMessageDialog(this, "Inicio de sesión exitoso como " + rol);
                abrirInterfazPorRol(rol);
            } else {
                JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos.");
            }
        });

        add(panel);
        setVisible(true);
    }

    private void abrirInterfazPorRol(String rol) {
        switch (rol) {
            case "Administrador":
                new grupo.proyecto.galeria.interfazAdmin.InterfazAdmin();
                break;
            case "Propietario":
                new grupo.proyecto.galeria.interfazPropietario.InterfazPropietario();
                break;
            case "Autor":
                new grupo.proyecto.galeria.interfazAutor.InterfazAutor();
                break;
            case "Operador":
                new grupo.proyecto.galeria.interfazOperador.InterfazOperador();
                break;
            case "Comprador":
                new grupo.proyecto.galeria.interfazComprador.InterfazComprador(rol, null);
                break;
            default:
                JOptionPane.showMessageDialog(this, "Rol desconocido. Por favor, contacte al administrador.");
                return;
        }
        dispose();
    }

    public static void main(String[] args) {
        UsuarioTipo.cargarUsuarios();
        new VentanaInicioSesion();
    }
}
