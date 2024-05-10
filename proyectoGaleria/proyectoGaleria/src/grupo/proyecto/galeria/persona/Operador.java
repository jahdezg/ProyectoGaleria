package grupo.proyecto.galeria.persona;

import grupo.proyecto.galeria.controladorSubasta.Subasta;

public class Operador extends Persona 
{
	private String nombre;
	private String tipo = "Operador";
	private String username;
	private String contrasenia;

	public Operador(String tipo, String nombre, String username, String contrasenia)
	{
		super(tipo, nombre, username, contrasenia);
	}

	public void registrarOferta(Subasta subasta, Double oferta, Comprador comprador) {
		return;
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