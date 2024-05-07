package grupo.proyecto.galeria.persona;

public abstract class Persona 
{
	protected String tipo;
	protected String nombre;
	protected String username;
	protected String contrasenia;
	
	public Persona(String tipo, String nombre, String username, String contrasenia) 
	{
		this.tipo = tipo;
		this.nombre = nombre;
		this.username = username;
		this.contrasenia = contrasenia;
	}
	
	public abstract String getTipo();
	public abstract String getNombre();
	public abstract String getUsername();
	public abstract String getContrasenia();
}
