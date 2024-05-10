package grupo.proyecto.galeria.persona;

public class Empleado extends Persona {

	public static final String tipo = "Empleado";
	private String nombre;
	private String username;
	private String contrasenia;


	public Empleado(String tipo, String nombre, String username, String contrasenia) 
	{
		super(tipo, nombre, username, contrasenia);
	}


	public void venderPieza() 
	{
		return;
	}

	public void agregarPieza() 
	{
		return;
	}

	public void devolverAlPropietario() 
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
