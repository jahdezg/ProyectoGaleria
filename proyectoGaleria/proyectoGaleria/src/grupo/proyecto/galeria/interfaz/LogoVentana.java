package grupo.proyecto.galeria.interfaz;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LogoVentana extends JPanel
{
	private JLabel lblLogo;
	public LogoVentana()
	{
		lblLogo = new JLabel("");
		lblLogo.setPreferredSize(new Dimension (900,130));
		add(lblLogo);
		
		ImageIcon fotico = new ImageIcon("./data/imagenes/logoporahora.png");
		lblLogo.setIcon(fotico);
	}
}
