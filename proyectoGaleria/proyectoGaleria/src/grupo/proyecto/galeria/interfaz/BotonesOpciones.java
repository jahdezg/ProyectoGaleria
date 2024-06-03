package grupo.proyecto.galeria.interfaz;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BotonesOpciones {

    private JPanel panel;
    private BufferedImage fondoImagen;

    public BotonesOpciones() {
    	
    	//caragar imagen
    	try
    	{
    		fondoImagen = ImageIO.read(new File("./data/imagenes/maybe1.JPG"));
    	}
    	catch(IOException e)
    	{
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
        panel.add(btnIniciarSesion, gbc);

        gbc.gridy++;
        JButton btnRegistrarUsuario = new JButton("Registrar Usuario");
        btnRegistrarUsuario.setPreferredSize(buttonSize);
        btnRegistrarUsuario.setBackground(Color.BLACK);
        btnRegistrarUsuario.setForeground(Color.WHITE);
        btnRegistrarUsuario.setBorderPainted(false);
        panel.add(btnRegistrarUsuario, gbc);

        gbc.gridy++;
        JButton btnSalir = new JButton("Salir");
        btnSalir.setPreferredSize(buttonSize);
        btnSalir.setBackground(Color.BLACK);
        btnSalir.setForeground(Color.WHITE);
        btnSalir.setBorderPainted(false);
        panel.add(btnSalir, gbc);

        btnIniciarSesion.addActionListener(e -> new VentanaInicioSesion());

        btnRegistrarUsuario.addActionListener(e -> new VentanaRegistroUsuario());

        btnSalir.addActionListener(e -> System.exit(0));
    }

    public JPanel getPanel() {
        return panel;
    }
}

