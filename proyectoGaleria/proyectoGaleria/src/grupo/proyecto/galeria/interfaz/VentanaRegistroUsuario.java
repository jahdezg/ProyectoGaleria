package grupo.proyecto.galeria.interfaz;

import grupo.proyecto.galeria.consola.UsuarioTipo;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class VentanaRegistroUsuario extends JFrame {

    public VentanaRegistroUsuario() {
        setTitle("Registro de Usuario");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JSplitPane divisionPanel = new JSplitPane();
        divisionPanel.setDividerLocation(400);

        JPanel panelFormulario = new JPanel();
        panelFormulario.setLayout(new GridBagLayout());
        divisionPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;

        JLabel usuarioLabel = new JLabel("Usuario:");
        panelFormulario.add(usuarioLabel, gbc);

        gbc.gridx = 1;
        JTextField usuarioField = new JTextField(20);
        panelFormulario.add(usuarioField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel contrasenaLabel = new JLabel("Contraseña:");
        panelFormulario.add(contrasenaLabel, gbc);

        gbc.gridx = 1;
        JPasswordField contrasenaField = new JPasswordField(20);
        panelFormulario.add(contrasenaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel rolLabel = new JLabel("Rol:");
        panelFormulario.add(rolLabel, gbc);

        gbc.gridx = 1;
        String[] roles = {"Comprador", "Propietario"};
        JComboBox<String> rolComboBox = new JComboBox<>(roles);
        panelFormulario.add(rolComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;

        JButton registrarButton = new JButton("Registrar Usuario");
        registrarButton.setBackground(Color.BLACK);
        registrarButton.setForeground(Color.WHITE);
        registrarButton.setBorderPainted(false);
        panelFormulario.add(registrarButton, gbc);

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
        
        JPanel panelImagen = new JPanel() {
            private BufferedImage imagen;

            {
                try 
                {
                    imagen = ImageIO.read(new File("./data/imagenes/ventanaRegistro.JPG")); 
                } 
                catch (IOException e) 
                {
                    e.printStackTrace();
                }
            }

            @Override
            protected void paintComponent(Graphics g) 
            {
                super.paintComponent(g);
                if (imagen != null) {
                    int width = getWidth();
                    int height = getHeight();
                    g.drawImage(imagen, 0, 0, width, height, this);
                }
            }
        };

        panelImagen.setPreferredSize(new Dimension(400, 600)); // Tamaño preferido para la mitad derecha

        divisionPanel.setRightComponent(panelFormulario);
        divisionPanel.setLeftComponent(panelImagen);

        add(divisionPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        UsuarioTipo.cargarUsuarios();
        new VentanaRegistroUsuario();
    }
}
