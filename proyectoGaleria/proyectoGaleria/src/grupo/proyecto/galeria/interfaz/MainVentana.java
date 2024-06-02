package grupo.proyecto.galeria.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MainVentana extends JFrame {
	
	private LogoVentana panelLogo;
	private IngresoVentana panelIngreso;
	
	public MainVentana() {
		setSize(900,700);
		setResizable(false);
		setTitle("GalArt");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLayout(new BorderLayout());
		panelLogo =new LogoVentana();
		add(panelLogo, BorderLayout.NORTH);
		
		panelIngreso = new IngresoVentana();
		add(panelIngreso, BorderLayout.CENTER);
		
	}
	
	public static void main(String[] args)
	{
		MainVentana princip = new MainVentana();
		princip.setLocationRelativeTo(null);
		princip.setVisible(true);
	}
}
