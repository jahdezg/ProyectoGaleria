package grupo.proyecto.galeria.interfaz;

import grupo.proyecto.galeria.consola.UsuarioTipo;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class VentanaInicioSesion extends JFrame {

    public VentanaInicioSesion() {
        setTitle("Iniciar Sesión");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JSplitPane panelDividido = new JSplitPane();
        panelDividido.setDividerLocation(400);
        
        JPanel panelFormulario = new JPanel();
        panelFormulario.setLayout(new GridBagLayout());
        panelFormulario.setBackground(Color.WHITE);
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
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;

        JButton iniciarSesionButton = new JButton("Iniciar Sesión");
        iniciarSesionButton.setBackground(Color.BLACK); 
        iniciarSesionButton.setForeground(Color.WHITE); 
        iniciarSesionButton.setBorderPainted(false);
        panelFormulario.add(iniciarSesionButton, gbc);

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
        
        JPanel panelImagen = new JPanel()
        		{
        	private BufferedImage imagen;
        	{
        		try {
        			imagen = ImageIO.read(new File ("./data/imagenes/ventanaLogin1.JPG"));
        			
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
        		if (imagen != null)
        		{
        			int width = getWidth();
                    int height = getHeight();
                    g.drawImage(imagen, 0, 0, width, height, this);
        		}
        	}
        		};
        		
    		panelImagen.setPreferredSize(new Dimension(400, 600)); // Tamaño preferido para la mitad derecha
    		panelDividido.setRightComponent(panelFormulario);
    		panelDividido.setLeftComponent(panelImagen);

            add(panelDividido);
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
