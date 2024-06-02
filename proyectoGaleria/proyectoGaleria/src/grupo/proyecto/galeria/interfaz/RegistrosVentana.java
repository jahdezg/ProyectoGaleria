package grupo.proyecto.galeria.interfaz;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class RegistrosVentana extends JFrame implements ActionListener{
	
	//no se si le ponemos un titulo
	
	private JLabel lblNombre;
	private JLabel lblContraseña;
	private JLabel lblRol;
	
	private JTextField nombre;
	private JTextField contraseña;
	
	private JButton crearUsuario;
	
	private JComboBox roles;
	
	public RegistrosVentana()
	{
		setLayout(new BorderLayout());
        setSize(600,400);
        setLocationRelativeTo(null);
        
        lblNombre = new JLabel("Nombre de Usuario: ");
        lblNombre.setBounds(70, 60,200,50);
        add(lblNombre);
        
        lblContraseña = new JLabel("Contraseña: ");
        lblContraseña.setBounds(70, 110,200,50);
        add(lblContraseña);
        
        lblRol = new JLabel("Rol: ");
        lblRol.setBounds(70, 160,200,50);
        add(lblRol);
        //Tal vez podemos crear un cosito para elegir el rol no TextBox
        
        nombre = new JTextField();
        nombre.setBounds(200, 70, 200, 30);
        add(nombre);
        
        contraseña = new JTextField();
        contraseña.setBounds(200, 120, 200, 30);
        add(contraseña);
        
        String[] tamaño = {"Administrador", "Cajero", "Comprador", "Propietario"};
		
		roles = new JComboBox(tamaño);
		roles.setBounds(200, 170, 200, 30);
		add(roles);
		
		crearUsuario = new JButton("Crear Usuario");
		crearUsuario.setBounds(100, 250, 185, 25);
		crearUsuario.addActionListener(this);
		add(crearUsuario);
        
        setLayout(null);
	}
	
	public String getTamano()
	{
		String size = (String) roles.getSelectedItem();
		switch (size)
		{
		case "Administrador":return "Administrador";
		case "Cajero":return "Cajero";
		case "Comprador":return "Comprador";
		case "Propietario":return "Propietario";
		default: return "Administrador"; //5x5
		
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(crearUsuario))
		{	
			String nombreUsuario = nombre.getText();
			String contraseñaNueva= contraseña.getText();
			String rolPersona = getTamano();
			//logica para meter los datos en el archivo txt
		}
		
	}
	
}
