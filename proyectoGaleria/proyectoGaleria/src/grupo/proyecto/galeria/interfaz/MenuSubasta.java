package grupo.proyecto.galeria.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class MenuSubasta extends JFrame implements ActionListener
{

	public MenuSubasta()
	{
		JFrame frame = new JFrame();
		BorderLayout borderLayout = new BorderLayout();
		borderLayout.setHgap(50);
		borderLayout.setVgap(50);
		frame.setLayout(borderLayout);
		
		JPanel titulo = new JPanel();
		JLabel texto = new JLabel("Menu Subasta");
		texto.setFont(new Font("Sans-serif", Font.BOLD, 36));
		texto.setForeground(Color.WHITE);
		titulo.setBorder(BorderFactory.createEmptyBorder(10,10,50,10));
		titulo.setBackground(Color.black);
		titulo.add(texto);
		
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0,1,0,30));
		panel.setPreferredSize(new Dimension(200, 75));
		panel.setBackground(Color.BLACK);
		
		JButton ps = new JButton("Participar en una Subasta");
		ps.addActionListener( this );
		ps.setActionCommand("ps");
		ps.setPreferredSize(new Dimension(200, 75));
		panel.add(ps);
		
		JButton salir = new JButton("Salir");
		salir.addActionListener( this );
		salir.setActionCommand("salir");
		salir.setPreferredSize(new Dimension(200, 75));
		panel.add(salir);
		
		frame.add(panel, BorderLayout.CENTER);	
		frame.add(titulo, BorderLayout.NORTH);
		frame.setTitle("Menu Subasta");
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setSize(1000, 720);
		frame.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getActionCommand().equals("ps"))
		{
			new VentanaSubasta();
		}
	}
	
	public static void main(String[] args) 
	{
		new MenuSubasta();
	}

}
