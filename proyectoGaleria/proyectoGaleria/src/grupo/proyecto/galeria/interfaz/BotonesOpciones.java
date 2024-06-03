package grupo.proyecto.galeria.interfaz;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BotonesOpciones implements ActionListener {

    private JPanel panel;
    private BufferedImage fondoImagen;

    public BotonesOpciones() {
        // Cargar imagen
        try {
            fondoImagen = ImageIO.read(new File("./data/imagenes/maybe1.JPG"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Crear un JPanel personalizado
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (fondoImagen != null) {
                    // Dibuja la imagen de fondo escalada al tamaño del panel
                    g.drawImage(fondoImagen, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };

        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;

        Dimension buttonSize = new Dimension(200, 40); // Tamaño preferido para los botones

        JButton btnIniciarSesion = new JButton("Iniciar Sesion");
        btnIniciarSesion.setPreferredSize(buttonSize);
        btnIniciarSesion.setBackground(Color.BLACK);
        btnIniciarSesion.setForeground(Color.WHITE);
        btnIniciarSesion.setBorderPainted(false);
        btnIniciarSesion.addActionListener(this);
        btnIniciarSesion.setActionCommand("iniciarSesion");
        panel.add(btnIniciarSesion, gbc);

        gbc.gridy++;
        JButton btnRegistrarUsuario = new JButton("Registrar Usuario");
        btnRegistrarUsuario.setPreferredSize(buttonSize);
        btnRegistrarUsuario.setBackground(Color.BLACK);
        btnRegistrarUsuario.setForeground(Color.WHITE);
        btnRegistrarUsuario.setBorderPainted(false);
        btnRegistrarUsuario.addActionListener(this);
        btnRegistrarUsuario.setActionCommand("registrarUsuario");
        panel.add(btnRegistrarUsuario, gbc);

        gbc.gridy++;
        JButton btnSubasta = new JButton("Participar en Subasta");
        btnSubasta.setPreferredSize(buttonSize);
        btnSubasta.setBackground(Color.BLACK);
        btnSubasta.setForeground(Color.WHITE);
        btnSubasta.setBorderPainted(false);
        btnSubasta.addActionListener(this);
        btnSubasta.setActionCommand("subasta");
        panel.add(btnSubasta, gbc);

        gbc.gridy++;
        JButton btnSalir = new JButton("Salir");
        btnSalir.setPreferredSize(buttonSize);
        btnSalir.setBackground(Color.BLACK);
        btnSalir.setForeground(Color.WHITE);
        btnSalir.setBorderPainted(false);
        btnSalir.addActionListener(this);
        btnSalir.setActionCommand("salir");
        panel.add(btnSalir, gbc);
    }

    public JPanel getPanel() {
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("iniciarSesion")) {
            new VentanaInicioSesion();
        } else if (command.equals("registrarUsuario")) {
            new VentanaRegistroUsuario();
        } else if (command.equals("subasta")) {
            new VentanaSubasta();
        } else if (command.equals("salir")) {
            System.exit(0);
        }
    }
}
