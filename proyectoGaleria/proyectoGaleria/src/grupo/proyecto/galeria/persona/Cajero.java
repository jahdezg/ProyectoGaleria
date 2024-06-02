package grupo.proyecto.galeria.persona;

import grupo.proyecto.galeria.Compra;
import grupo.proyecto.galeria.Pago;
import grupo.proyecto.galeria.inventarioPiezas.Pieza;

public class Cajero extends Persona {

	private String nombre;
	private static String tipo = "Cajero";
	private static String username;
	private static String contrasenia;

	public Cajero(String tipo, String nombre, String username, String contrasenia) 
	{
		super(tipo, nombre, username, contrasenia);
	}

	public void registroDePago(Compra compra, String metodoDePago, Pago pago, Comprador comprador,
			Propietario propietario, Pieza pieza) {

	}

	public void administrarInventario() 
	{

	}


	public void actualizarInventario() 
	{

	}

	@Override
	public String getNombre() 
	{
		return nombre;
	}

	@Override
	public String getTipo() 
	{
		return tipo;
	}

	@Override
	public String getUsername() 
	{
		return username;
	}

	@Override
	public String getContrasenia() 
	{
		return contrasenia;
	}

}
