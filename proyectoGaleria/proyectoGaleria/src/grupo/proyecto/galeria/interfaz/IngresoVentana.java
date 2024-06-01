package grupo.proyecto.galeria.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class IngresoVentana extends JPanel implements ActionListener
{
	
	private LogInVentana logVentana;
	private JButton ingresar;
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JPanel panel4 = new JPanel();
	
	
	
	public IngresoVentana()
	{
		setLayout(new BorderLayout());
		
		
		ingresar = new JButton("Entrar");
		ingresar.setBackground(new Color (207, 185, 151));
		add(ingresar, BorderLayout.CENTER);
		ingresar.addActionListener( this );
		ingresar.setActionCommand( "INGRESAR" );
		
		panel1.setBackground(Color.BLACK);
		panel2.setBackground(Color.BLACK);
		panel3.setBackground(Color.BLACK);
		panel4.setBackground(Color.BLACK);
		
		panel1.setPreferredSize(new Dimension (900,220));
		panel2.setPreferredSize(new Dimension (900,220));
		panel3.setPreferredSize(new Dimension (290,200));
		panel4.setPreferredSize(new Dimension (290,200));
		
		add(panel1, BorderLayout.NORTH);
		add(panel2, BorderLayout.SOUTH);
		add(panel3, BorderLayout.WEST);
		add(panel4, BorderLayout.EAST);
		
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("INGRESAR"))
		{
			//JOptionPane.showMessageDialog(null,"mensaje","A plain message",JOptionPane.PLAIN_MESSAGE);
			JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            LogInVentana loginWindow = new LogInVentana(parentFrame, null);
            loginWindow.setVisible(true);
		}
		
	}

}
