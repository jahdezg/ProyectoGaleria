package grupo.proyecto.galeria.interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaSubasta extends JFrame implements ActionListener
{
	
	int oferta = 0;
	public JLabel ofert;
	public List<Integer> ofertas = new ArrayList<Integer>();
	
	public VentanaSubasta()
	{
		JFrame frame = new JFrame();
		BorderLayout borderLayout = new BorderLayout();
		frame.setLayout(borderLayout);
		
		JPanel panel1 = new JPanel(new GridLayout(0,1));
		
		JButton inc = new JButton("Incrementar Oferta");
		inc.addActionListener( this );
		inc.setActionCommand("inc");
		panel1.add(inc);
		
		JButton dec = new JButton("Disminuir Oferta");
		dec.addActionListener( this );
		dec.setActionCommand("dec");
		panel1.add(dec);
		
		frame.add(panel1, BorderLayout.EAST);
		
		JPanel panel2 = new JPanel();
		JLabel montoIn = new JLabel("Monto Inicial: 150$");
		panel2.add(montoIn);
		frame.add(panel2, BorderLayout.NORTH);
		
		JPanel panel3 = new JPanel(new FlowLayout());
		ofert = new JLabel();
		ofert.setText("Oferta: " + Integer.toString(oferta) + "$");
		JButton confirmar = new JButton("Confirmar");
		confirmar.addActionListener(this);
		confirmar.setActionCommand("confirmar");
		panel3.add(ofert);
		panel3.add(confirmar);
		frame.add(panel3, BorderLayout.CENTER);
		
		JButton ofers = new JButton("Ofertas Realizadas");
		ofers.addActionListener(this);
		ofers.setActionCommand("ofers");
		frame.add(ofers, BorderLayout.WEST);
		
		frame.setTitle("Subasta");
		frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		frame.setSize(1000, 720);
		frame.setVisible(true);
	}


	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals("inc"))
		{
			oferta += 100;
			ofert.setText("Oferta: " + Integer.toString(oferta) + "$");
		}
		else if(e.getActionCommand().equals("dec"))
		{
			if(oferta > 0)
			{
				oferta -= 100;
				ofert.setText("Oferta: " + Integer.toString(oferta) + "$");
			}
		}
		else if (e.getActionCommand().equals("confirmar"))
		{
			if (oferta != 0)
			{ofertas.add(oferta);}
		}
		else if(e.getActionCommand().equals("ofers"))
		{
			new OfertasSubasta(ofertas);
			
		}
	}

}
