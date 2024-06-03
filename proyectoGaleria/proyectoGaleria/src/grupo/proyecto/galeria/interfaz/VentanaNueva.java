package grupo.proyecto.galeria.interfaz;

import grupo.proyecto.galeria.consola.UsuarioTipo;

import javax.swing.*;
import java.awt.*;

public class VentanaNueva extends JFrame {
	
	private LogoVentana panelLogo;

    public VentanaNueva() {
        setTitle("Menu Principal");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        UsuarioTipo.cargarUsuarios();

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.BLACK);

        BotonesOpciones botonesOpciones = new BotonesOpciones();
        JPanel botonesPanel = botonesOpciones.getPanel();
        mainPanel.add(botonesPanel, BorderLayout.CENTER);

        add(mainPanel);

        setVisible(true);
        
        //setLayout(new BorderLayout());
		panelLogo =new LogoVentana();
		add(panelLogo, BorderLayout.NORTH);
    }

    public static void main(String[] args) {
        new VentanaNueva();
    }
}

