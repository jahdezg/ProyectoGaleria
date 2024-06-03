package grupo.proyecto.galeria.interfaz;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class OfertasSubasta extends JFrame
{
	public OfertasSubasta(List<Integer> ofertas)
	{
		JFrame frame = new JFrame();
		JPanel panel = new JPanel(new GridLayout(0,2,10,10));
		panel.setBackground(Color.CYAN);
		for(int i : ofertas)
		{
			JLabel x = new JLabel("Nombre: " + Integer.toString(i));
			x.setBackground(Color.DARK_GRAY);
			panel.add(x);
		}
		frame.add(panel);
		frame.setTitle("Ofertas");
		frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		frame.setSize(1000, 720);
		frame.setVisible(true);
	}
}