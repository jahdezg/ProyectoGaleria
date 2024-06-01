package grupo.proyecto.galeria.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LogInVentana extends JFrame implements ActionListener
{
	private JTextField usuario;
    private JPasswordField contraseña;
    private JButton loginButton;
    private JButton crearUsuario;
    private JLabel IdUsuario;
    private JLabel contra;
    private JLabel mensaje;
    
    HashMap<String, String> logininfo = new HashMap<String, String>();
    
    
    
    public LogInVentana(JFrame parent, HashMap<String,String> loginInfoOriginal) {
        super();
        setLayout(new BorderLayout());
        setSize(600,400);
        setLocationRelativeTo(parent);
        
        logininfo = loginInfoOriginal;
        
        JPanel panel = new JPanel(new GridLayout(3, 2));
        
        IdUsuario = new JLabel("Usuario: ");
        IdUsuario.setBounds(100, 100,75,25);
        add(IdUsuario);
        
        mensaje = new JLabel();
        mensaje.setBounds(125, 300,250,35);
        mensaje.setFont(new Font(null, Font.ITALIC,25));
        add(mensaje);
        
        
        usuario = new JTextField();
        usuario.setBounds(190,100,200,25);
        add(usuario);
        
        contra = new JLabel("Contraseña: ");
        contra.setBounds(100, 180,75,20);
        add(contra);
        

        contraseña = new JPasswordField();
        contraseña.setBounds(190,180,200,25);
        add(contraseña);
        
        loginButton = new JButton("Login");
        loginButton.setBounds(125, 250, 100, 25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);
        add(loginButton);
        
        //loginButton.addActionListener(new ActionListener() {
           // @Override
            //public void actionPerformed(ActionEvent e) {
               // String user = usuario.getText();
               // char[] password = contraseña.getPassword();
                // lógica para verificar el usuario y la contraseña.
                //JOptionPane.showMessageDialog(LogInVentana.this, 
                   //     "Usuario: " + user + "\nContraseña: " + new String(password));
                //dispose();
           // }
        //});
        
        crearUsuario = new JButton("Registrarse");
        crearUsuario.setBounds(300, 250, 100, 25);
        crearUsuario.setFocusable(false);
        crearUsuario.addActionListener(this);
        add(crearUsuario);
        
        
        add(panel, BorderLayout.CENTER);
        //add(loginButton, BorderLayout.SOUTH);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(crearUsuario))
		{
			RegistrosVentana registrosVentana =  new RegistrosVentana();
			registrosVentana.setVisible(true);
			
			//logica
		}
		else if (e.getSource().equals(loginButton))
		{
			String userID= usuario.getText();
			String password= String.valueOf(contraseña.getPassword());
			
			if(logininfo.containsKey(userID))
			{
				if(logininfo.get(userID).equals(password))
				{
					mensaje.setForeground(Color.green);
					mensaje.setText("Login exitoso");
					SiguienteMenu siguienteMenu = new SiguienteMenu();
					//toca mirar porque hay mas que solo contraseña
				}
			}
		}
		
	}
	
}
